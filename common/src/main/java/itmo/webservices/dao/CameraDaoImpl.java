package itmo.webservices.dao;

import itmo.webservices.Utils;
import itmo.webservices.models.Brand;
import itmo.webservices.models.Camera;
import itmo.webservices.models.CameraType;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by anastasia.sulyagina
 */
public class CameraDaoImpl implements CameraDao {
    private static final Logger LOGGER = Logger.getLogger(CameraDaoImpl.class.getCanonicalName());

    private final JdbcTemplate template = Utils.getJdbcTemplate();

    public List<Camera> find(String model, Brand brand, Boolean fullFrame, CameraType cameraType, Boolean fixedLens) {
        String brandString = brand == null ? null : brand.name();
        String cameraTypeString = cameraType == null ? null : cameraType.name();
        return template.query("SELECT * FROM cameras WHERE " +
                        "model = COALESCE(?, model) AND " +
                        "brand = COALESCE(?, brand)  AND " +
                        "full_frame = COALESCE(?, full_frame) AND " +
                        "camera_type = COALESCE(?, camera_type) AND " +
                        "fixed_lens = COALESCE(?, fixed_lens)",
                new BeanPropertyRowMapper<>(Camera.class), model, brandString, fullFrame, cameraTypeString, fixedLens);
    }

    public int create(String model, Brand brand, Boolean fullFrame, CameraType cameraType, Boolean fixedLens) {
        final GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        template.update(conn -> {
            final PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO cameras (model, brand, full_frame, camera_type, fixed_lens) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, model);
            st.setString(2, brand.name());
            st.setBoolean(3, fullFrame);
            st.setString(4, cameraType.name());
            st.setBoolean(5, fixedLens);
            return st;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    public boolean update(int id, String model, Brand brand, Boolean fullFrame, CameraType cameraType, Boolean fixedLens) {
        try {
            int count = template.update(conn -> {
                final PreparedStatement st = conn.prepareStatement(
                        "UPDATE cameras SET model = ?, brand = ?, full_frame = ?, camera_type = ?, fixed_lens = ? WHERE id = ?",
                        Statement.RETURN_GENERATED_KEYS);
                st.setString(1, model);
                st.setString(2, brand.name());
                st.setBoolean(3, fullFrame);
                st.setString(4, cameraType.name());
                st.setBoolean(5, fixedLens);
                st.setInt(6, id);
                return st;
            });
            return count == 1;
        } catch (DataAccessException e) {
            LOGGER.log(Level.ALL, "Unable to update Camera", e);
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            int count = template.update(conn -> {
                final PreparedStatement st = conn.prepareStatement("DELETE FROM cameras WHERE id = ?",
                        Statement.RETURN_GENERATED_KEYS);
                st.setInt(1,  id);
                return st;
            });
            return count == 1;
        } catch (DataAccessException e) {
            LOGGER.log(Level.ALL, "Unable to delete Camera", e);
            return false;
        }
    }
}
