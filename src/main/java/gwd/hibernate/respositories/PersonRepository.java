package gwd.hibernate.respositories;

import gwd.hibernate.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("SELECT p FROM Person p ORDER BY p.id")
    List<Person> findAllSortById();

    @Query("SELECT p FROM Person p WHERE p.age=?1")
    List<Person> findByMyAge(Integer age);

    @Query("SELECT p FROM Person p WHERE p.name=?1 OR p.age=?2")
    List<Person> findByNameOrAge(String name, Integer age);

    // T - to user
    // ID - Integer
    // S - to tez w skrócie user bo na S mozemy powiedizec user, mamy 11 metod w tym interfacie
    // ale wszystkie sa puste
//
//    @Override
//    public <S extends User> S save(S s) {
//        return null;
//    }
//
//    @Override
//    public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
//        return null;
//    }
//
//    @Override
//    public Optional<User> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public Iterable<User> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable<User> findAllById(Iterable<Integer> iterable) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(User user) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends User> iterable) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
}
