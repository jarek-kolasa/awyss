package awyss.repository;

import awyss.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

    Boolean existsByClientNameIgnoreCase( String clientName );
//
//    List<Client> findByClientName( String clientName );
//    List<Client> findByClientNameContaining( String clientName );
    List<Client> findByClientNameContainingIgnoreCase( String clientName );

    @Query(value = "SELECT * FROM clients WHERE clientName = :clientname", nativeQuery = true)
    List<Client> search( @Param("clientname") String clientName );

    boolean existsById( Long id );

    void deleteById( Long id );

    Optional<Client> findById( Long id );
}
