package itmo.webservices;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import itmo.webservices.dao.CameraDao;
import itmo.webservices.dao.CameraDaoImpl;
import itmo.webservices.models.Brand;
import itmo.webservices.models.CameraType;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.util.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by anastasia.sulyagina
 */
public class Utils {
    private static final Logger LOGGER = Logger.getLogger(Utils.class.getCanonicalName());

    static {
        final ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        LOGGER.addHandler(handler);
        LOGGER.setLevel(Level.ALL);
    }

    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";//

    private static JdbcTemplate jdbcTemplate;

    public static JdbcTemplate getJdbcTemplate() {
        if (Utils.jdbcTemplate == null) {
            synchronized (JdbcUtils.class) {
                if (Utils.jdbcTemplate == null) {
                    final JdbcDataSource dataSource = new JdbcDataSource();
                    dataSource.setURL(URL);
                    Utils.jdbcTemplate = new JdbcTemplate(dataSource);
                }
            }
        }
        return jdbcTemplate;

    }

    public static void initDB() {
        getJdbcTemplate().execute("DROP TABLE cameras IF EXISTS");
        getJdbcTemplate().execute("CREATE TABLE cameras (" +
                "id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
                "model VARCHAR, " +
                "brand VARCHAR, " +
                "full_frame BOOLEAN, " +
                "camera_type VARCHAR, " +
                "fixed_lens BOOLEAN " +
                ")");

        final CameraDao cameraDao = new CameraDaoImpl();
        cameraDao.create("6D", Brand.CANON, true, CameraType.MIRROR, false);
        cameraDao.create("600D", Brand.CANON, false, CameraType.MIRROR, false);
        cameraDao.create("PowerShot SX620 HS", Brand.CANON, false, CameraType.OPTICAL, true);
        cameraDao.create("D5600", Brand.NIKON, false, CameraType.MIRROR, false);
    }
}
