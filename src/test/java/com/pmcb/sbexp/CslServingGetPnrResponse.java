package com.pmcb.sbexp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CslServingGetPnrResponse {

    private String status;
    private String code;
    private String message;

    private ResponseBody responseBody;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    static class ResponseBody {

        private String bookingReference;
        private String isAltea;
        private String currency;
        private List<Passenger> passengers;
        private List<Flight> flights;
        private boolean unaccompaniedMinor;
        private String sessionID;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class Passenger {

        private String passengerID;
        private String passengerType;
        private String lastName;
        private String firstName;
        private String title;
        private String ticketNumber;
        private String gender;
        private List<AdditionalDetails> additionalPassengerDetails;
        private FrequentFlyerDetails frequentFlyerDetails;
        private List<ContactDetail> contactDetails;
        private List<SeatDetail> seatDetails;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class AdditionalDetails {

        private String documentType;
        private String documentNumber;
        private String expiryDate;
        private String issuingCountry;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class FrequentFlyerDetails {

        private String loyaltyTierCode;
        private String frequentFlyerAirline;
        private String frequentFlyerNumber;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class ContactDetail {

        private String home;
        private String email;
        private String countryCode;
        private String areaCode;
        private String mobile;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class SeatDetail {
        private String flightID;
        private String seatNumber;
        private String seatStatus;
        private boolean preferred;
        private boolean complimentary;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class Flight {

        private List<Segment> flightSegment;
        private ODDetails origin;
        private ODDetails destination;
        private String flightNumber;
        private String flightId;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class Segment {

        private String marketingAirlineCode;
        private String marketingAirlineName;
        private ODDetails origin;
        private ODDetails destination;
        private String scheduledDepartureTime;
        private String scheduledArrivalTime;
        private String estimatedDepartureTime;
        private String estimatedArrivalTime;
        private String cabinClass;
        private String sellingClass;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    static class ODDetails {
        private String airportCode;
        private String airportName;
        private String terminalNumber;
        private String countryCode;
    }
}

