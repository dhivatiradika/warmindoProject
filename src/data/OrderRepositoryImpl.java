package data;

import domain.entity.Noodle;
import domain.repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {
    private final ApplicationData applicationData = ApplicationData.getInstance();

    @Override
    public Noodle getTomporaryNoodle() {
        return applicationData.getTemporaryNoodle();
    }

    @Override
    public void setTemporaryNoodle(Noodle noodle) {
        applicationData.setTemporaryNoodle(noodle);
    }

    @Override
    public String getTemporaryVariant() {
        return applicationData.getTemporaryVariant();
    }

    @Override
    public void setTemporaryVariant(String variant) {
        applicationData.setTemporaryVariant(variant);
    }
}
