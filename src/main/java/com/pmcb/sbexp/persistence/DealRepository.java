package com.pmcb.sbexp.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<DealEntity, Long> {

    @Query("SELECT u FROM #{#entityName} u "
        + "WHERE u.originAirportCode = ?1 "
        + "AND u.locale = ?2 "
        + "AND u.promotionMode = 'Commercial' "
        + "AND u.promotionFareType = 'PASSTHRU' "
        + "ORDER BY u.fare")
    List<DealEntity> findAirportDeals(String originAirportCode, String locale);

    @Query("SELECT u FROM #{#entityName} u "
        + "WHERE u.originCityCode = ?1 "
        + "AND u.locale = ?2 "
        + "AND u.promotionMode = 'Commercial' "
        + "AND u.promotionFareType = 'PASSTHRU' "
        + "ORDER BY u.fare")
    List<DealEntity> findCityDeals(String originCityCode, String locale);

    DealEntity findByPromoFareId(Long promoFareId);
}
