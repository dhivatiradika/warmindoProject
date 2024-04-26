package domain.repository;

import domain.entity.Noodle;

public interface OrderRepository {
    Noodle getTomporaryNoodle();
    void setTemporaryNoodle(Noodle noodle);
    String getTemporaryVariant();
    void setTemporaryVariant(String variant);
}
