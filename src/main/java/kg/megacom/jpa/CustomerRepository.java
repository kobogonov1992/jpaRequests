package kg.megacom.jpa;

import org.aspectj.weaver.ast.Var;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastNameOrFirstNameEquals(String lastName,String lastName2);

    List<Customer> findByLastNameAndFirstName(String lastName,String firstName);

    List<Customer> findByLastNameOrFirstName(String lastName,String firstName);

    List<Customer> findByAgeGreaterThanAndAgeLessThanEqual(int age1,int age2 );

    List<Customer>  findByStartDateBeforeAndStartDateAfter(LocalDate startDate,LocalDate endDate );

    List<Customer>  findByAgeNull();

    List<Customer>  findByFirstNameLike(String firstName);

    List<Customer>  findByFirstNameStartingWithAndFirstNameContainingAndFirstNameEndingWith
            (String firstName1,String firstName2,String endingLetter);

    List<Customer>   findByAgeOrderByLastNameDesc(Integer age);

    List<Customer>   findByLastNameNot(String lastName);

    List<Customer>   findByAgeIn(Collection<Integer> ages);

    List<Customer>  findByAgeNotIn(Collection<Integer> ages);

    List<Customer>  findByActiveTrueOrActiveFalse();


    List<Customer> findByFirstNameIgnoreCase(String firstName);

    Customer findById(long id);

}