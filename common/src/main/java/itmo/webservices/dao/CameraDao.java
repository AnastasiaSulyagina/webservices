package itmo.webservices.dao;

import itmo.webservices.models.Brand;
import itmo.webservices.models.Camera;
import itmo.webservices.models.CameraType;

import java.util.List;

/**
 * Created by anastasia.sulyagina
 */
public interface CameraDao {
    List<Camera> find(String model, Brand brand, Boolean fullFrame, CameraType cameraType, Boolean fixedLens);

    int create(String model, Brand brand, Boolean fullFrame, CameraType cameraType, Boolean fixedLens);

    boolean update(int id, String model, Brand brand, Boolean fullFrame, CameraType cameraType, Boolean fixedLens);

    boolean delete(int id);
}
