package com.pmcb.sbexp.persistence;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "msl_fare_deal")
public class DealEntity {

    @Id
    private Long id;

    private String locale;
    private String promotionMode;
    private String promotionFareType;
    private String tripType;
    @Temporal(TemporalType.DATE)
    private Date salePeriodStartDate;
    @Temporal(TemporalType.DATE)
    private Date salePeriodEndDate;
    private String originAirportCode;
    private String originCityCode;
    private String originCityName;
    private String destinationAirportCode;
    private String destinationCityCode;
    private String destinationCityName;
    private Integer advancePurchasePeriodInDay;
    private Integer minPax;
    private String imgUrl;
    private Long fare;
    private String currencyCode;
    private String cabinClass;
    private String cabinClassName;
    private Long promoFareId;
    private String cancellation;
    private String rebooking;
    private String outboundFlights;
    private String inboundFlights;
    private String mileageUpgradable;
    private String mileageAccruable;
    private String maxStayInDaysMonths;
    private Integer maxStay;
    private String minStayInDaysMonths;
    private Integer minStay;
    private String cancellationRefund;
    private String itineraryChange;
    @Temporal(TemporalType.DATE)
    private Date travelCompletionDate;
    private int appOnlyFare;
    private int promoPriorityHook;
    private String otherConditions;
    private String specialConditions;

    @Convert(converter = DealEntityTravelPeriodsConverter.class)
    private List<TravelPeriod> outboundPeriods;

    @Convert(converter = DealEntityTravelPeriodsConverter.class)
    private List<TravelPeriod> inboundPeriods;

    @Value
    @Builder
    @AllArgsConstructor
    public static class TravelPeriod {

        private String s;
        private String e;
    }
}
