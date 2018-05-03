package kz.kaznitu.fastfood.repositories;

import kz.kaznitu.fastfood.models.Klient;
import org.springframework.data.repository.CrudRepository;

public interface KlientRepository extends CrudRepository<Klient,Long> {
}
