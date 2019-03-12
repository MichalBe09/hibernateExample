package gwd.hibernate.respositories;

import gwd.hibernate.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

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
