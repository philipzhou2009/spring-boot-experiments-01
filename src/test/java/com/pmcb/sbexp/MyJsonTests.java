package com.pmcb.sbexp;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.json.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.json.*;
import org.springframework.test.context.junit4.*;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@JsonTest
public class MyJsonTests {

    @Autowired
    private JacksonTester<VehicleDetails> json;

    @Ignore
    @Test
    public void testSerialize() throws Exception {
        VehicleDetails details = new VehicleDetails("Honda", "Civic");
        // Assert against a `.json` file in the same package as the test
        assertThat(this.json.write(details)).isEqualToJson("expected.json");
        // Or use JSON path based assertions
        assertThat(this.json.write(details)).hasJsonPathStringValue("@.make");
        assertThat(this.json.write(details)).extractingJsonPathStringValue("@.make")
                .isEqualTo("Honda");
    }

    @Test
    public void testDeserialize() throws Exception {
        /* language=json */
        String content = "{\n" +
                "  \"make\": \"Ford\",\n" +
                "  \"model\": \"Focus\",\n" +
                "  \"owner\": \"Philip\"\n" +
                "}";
        assertThat(this.json.parse(content))
                .isEqualTo(new VehicleDetails("Ford", "Focus"));
        assertThat(this.json.parseObject(content).getMake()).isEqualTo("Ford");
    }

    @Test
    public void getPNR_verifyResponse() throws Exception {

        // language=json
        String json = "{\n" +
                "    \"status\": \"SUCCESS\",\n" +
                "    \"code\": \"200\",\n" +
                "    \"message\": \"\",\n" +
                "    \"responseBody\": {\n" +
                "        \"bookingReference\": \"M7P9HW\",\n" +
                "        \"isAltea\": \"true\",\n" +
                "        \"currency\": \"PLN\",\n" +
                "        \"passengers\": [\n" +
                "            {\n" +
                "                \"passengerID\": \"2\",\n" +
                "                \"passengerType\": \"ADT\",\n" +
                "                \"lastName\": \"LMDCOAMDA\",\n" +
                "                \"firstName\": \"Testing\",\n" +
                "                \"title\": \"Miss\",\n" +
                "                \"ticketNumber\": \"6182421811675\",\n" +
                "                \"gender\": \"FEMALE\",\n" +
                "                \"additionalPassengerDetails\": [\n" +
                "                    {\n" +
                "                        \"documentType\": \"PASSPORT\",\n" +
                "                        \"documentNumber\": \"F12345854\",\n" +
                "                        \"expiryDate\": \"2020-04-04\",\n" +
                "                        \"issuingCountry\": \"AL\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"frequentFlyerDetails\": {\n" +
                "                    \"loyaltyTierCode\": \"LPPS\",\n" +
                "                    \"frequentFlyerAirline\": \"SQ\",\n" +
                "                    \"frequentFlyerNumber\": \"8987009407\"\n" +
                "                },\n" +
                "                \"contactDetails\": [\n" +
                "                    {\n" +
                "                        \"home\": \"12345678\",\n" +
                "                        \"email\": \"CMT_DEVMAIL@SQDEV.COM.SG\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"home\": \"12345678\",\n" +
                "                        \"email\": \"CMT_DEVMAIL@SQDEV.COM.SG\",\n" +
                "                        \"countryCode\": \"93\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"mobile\": \"4231465\",\n" +
                "                        \"email\": \"CMT_DEVMAIL@SQDEV.COM.SG\",\n" +
                "                        \"areaCode\": \"13\",\n" +
                "                        \"countryCode\": \"93\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"home\": \"12345678\",\n" +
                "                        \"email\": \"CMT_DEVMAIL@SQDEV.COM.SG\",\n" +
                "                        \"countryCode\": \"93\"\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"mobile\": \"4231465\",\n" +
                "                        \"email\": \"CMT_DEVMAIL@SQDEV.COM.SG\",\n" +
                "                        \"areaCode\": \"13\",\n" +
                "                        \"countryCode\": \"93\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"seatDetails\": [\n" +
                "                    {\n" +
                "                        \"flightID\": \"2\",\n" +
                "                        \"seatNumber\": \"43J\",\n" +
                "                        \"seatStatus\": \"HK\",\n" +
                "                        \"preferred\": true,\n" +
                "                        \"complimentary\": true\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"flightID\": \"3\",\n" +
                "                        \"seatNumber\": \"47C\",\n" +
                "                        \"seatStatus\": \"HK\",\n" +
                "                        \"preferred\": true,\n" +
                "                        \"complimentary\": true\n" +
                "                    }\n" +
                "                ]\n" +
                "            }\n" +
                "        ],\n" +
                "        \"flights\": [\n" +
                "            {\n" +
                "                \"flightSegment\": [\n" +
                "                    {\n" +
                "                        \"marketingAirlineCode\": \"LO\",\n" +
                "                        \"marketingAirlineName\": \"LOT Polish Airlines\",\n" +
                "                        \"origin\": {\n" +
                "                            \"airportCode\": \"WAW\",\n" +
                "                            \"airportName\": \"Frederic Chopin\",\n" +
                "                            \"countryCode\": \"PL\"\n" +
                "                        },\n" +
                "                        \"destination\": {\n" +
                "                            \"airportCode\": \"ZRH\",\n" +
                "                            \"airportName\": \"Zurich   Kloten\",\n" +
                "                            \"countryCode\": \"CH\"\n" +
                "                        },\n" +
                "                        \"scheduledDepartureTime\": \"2018-03-22 07:40:00.000\",\n" +
                "                        \"scheduledArrivalTime\": \"2018-03-22 09:40:00.000\",\n" +
                "                        \"estimatedDepartureTime\": \"2018-03-22 07:40:00.000\",\n" +
                "                        \"estimatedArrivalTime\": \"2018-03-22 09:40:00.000\",\n" +
                "                        \"cabinClass\": \"ECONOMY\",\n" +
                "                        \"sellingClass\": \"S\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"origin\": {\n" +
                "                    \"airportCode\": \"WAW\",\n" +
                "                    \"airportName\": \"Frederic Chopin\",\n" +
                "                    \"countryCode\": \"PL\"\n" +
                "                },\n" +
                "                \"destination\": {\n" +
                "                    \"airportCode\": \"ZRH\",\n" +
                "                    \"airportName\": \"Zurich   Kloten\",\n" +
                "                    \"countryCode\": \"CH\"\n" +
                "                },\n" +
                "                \"flightNumber\": \"411\",\n" +
                "                \"flightId\": \"1\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"flightSegment\": [\n" +
                "                    {\n" +
                "                        \"marketingAirlineCode\": \"SQ\",\n" +
                "                        \"marketingAirlineName\": \"Singapore Airlines\",\n" +
                "                        \"origin\": {\n" +
                "                            \"airportCode\": \"ZRH\",\n" +
                "                            \"airportName\": \"Zurich   Kloten\",\n" +
                "                            \"countryCode\": \"CH\"\n" +
                "                        },\n" +
                "                        \"destination\": {\n" +
                "                            \"airportCode\": \"SIN\",\n" +
                "                            \"airportName\": \"Changi Intl\",\n" +
                "                            \"terminalNumber\": \"0\",\n" +
                "                            \"countryCode\": \"SG\"\n" +
                "                        },\n" +
                "                        \"scheduledDepartureTime\": \"2018-03-22 10:35:00.000\",\n" +
                "                        \"scheduledArrivalTime\": \"2018-03-23 06:00:00.000\",\n" +
                "                        \"estimatedDepartureTime\": \"2018-03-22 10:35:00.000\",\n" +
                "                        \"estimatedArrivalTime\": \"2018-03-23 06:00:00.000\",\n" +
                "                        \"cabinClass\": \"ECONOMY\",\n" +
                "                        \"sellingClass\": \"E\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"origin\": {\n" +
                "                    \"airportCode\": \"ZRH\",\n" +
                "                    \"airportName\": \"Zurich   Kloten\",\n" +
                "                    \"countryCode\": \"CH\"\n" +
                "                },\n" +
                "                \"destination\": {\n" +
                "                    \"airportCode\": \"SIN\",\n" +
                "                    \"airportName\": \"Changi Intl\",\n" +
                "                    \"countryCode\": \"SG\"\n" +
                "                },\n" +
                "                \"flightNumber\": \"345\",\n" +
                "                \"flightId\": \"2\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"flightSegment\": [\n" +
                "                    {\n" +
                "                        \"marketingAirlineCode\": \"SQ\",\n" +
                "                        \"marketingAirlineName\": \"Singapore Airlines\",\n" +
                "                        \"origin\": {\n" +
                "                            \"airportCode\": \"SIN\",\n" +
                "                            \"airportName\": \"Changi Intl\",\n" +
                "                            \"terminalNumber\": \"3\",\n" +
                "                            \"countryCode\": \"SG\"\n" +
                "                        },\n" +
                "                        \"destination\": {\n" +
                "                            \"airportCode\": \"DUS\",\n" +
                "                            \"airportName\": \"Dusseldorf Intl\",\n" +
                "                            \"countryCode\": \"DE\"\n" +
                "                        },\n" +
                "                        \"scheduledDepartureTime\": \"2018-04-10 23:30:00.000\",\n" +
                "                        \"scheduledArrivalTime\": \"2018-04-11 06:30:00.000\",\n" +
                "                        \"estimatedDepartureTime\": \"2018-04-10 23:30:00.000\",\n" +
                "                        \"estimatedArrivalTime\": \"2018-04-11 06:30:00.000\",\n" +
                "                        \"cabinClass\": \"ECONOMY\",\n" +
                "                        \"sellingClass\": \"W\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"origin\": {\n" +
                "                    \"airportCode\": \"SIN\",\n" +
                "                    \"airportName\": \"Changi Intl\",\n" +
                "                    \"countryCode\": \"SG\"\n" +
                "                },\n" +
                "                \"destination\": {\n" +
                "                    \"airportCode\": \"DUS\",\n" +
                "                    \"airportName\": \"Dusseldorf Intl\",\n" +
                "                    \"countryCode\": \"DE\"\n" +
                "                },\n" +
                "                \"flightNumber\": \"338\",\n" +
                "                \"flightId\": \"3\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"flightSegment\": [\n" +
                "                    {\n" +
                "                        \"marketingAirlineCode\": \"LO\",\n" +
                "                        \"marketingAirlineName\": \"LOT Polish Airlines\",\n" +
                "                        \"origin\": {\n" +
                "                            \"airportCode\": \"DUS\",\n" +
                "                            \"airportName\": \"Dusseldorf Intl\",\n" +
                "                            \"countryCode\": \"DE\"\n" +
                "                        },\n" +
                "                        \"destination\": {\n" +
                "                            \"airportCode\": \"WAW\",\n" +
                "                            \"airportName\": \"Frederic Chopin\",\n" +
                "                            \"countryCode\": \"PL\"\n" +
                "                        },\n" +
                "                        \"scheduledDepartureTime\": \"2018-04-11 07:20:00.000\",\n" +
                "                        \"scheduledArrivalTime\": \"2018-04-11 09:10:00.000\",\n" +
                "                        \"estimatedDepartureTime\": \"2018-04-11 07:20:00.000\",\n" +
                "                        \"estimatedArrivalTime\": \"2018-04-11 09:10:00.000\",\n" +
                "                        \"cabinClass\": \"ECONOMY\",\n" +
                "                        \"sellingClass\": \"W\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"origin\": {\n" +
                "                    \"airportCode\": \"DUS\",\n" +
                "                    \"airportName\": \"Dusseldorf Intl\",\n" +
                "                    \"countryCode\": \"DE\"\n" +
                "                },\n" +
                "                \"destination\": {\n" +
                "                    \"airportCode\": \"WAW\",\n" +
                "                    \"airportName\": \"Frederic Chopin\",\n" +
                "                    \"countryCode\": \"PL\"\n" +
                "                },\n" +
                "                \"flightNumber\": \"406\",\n" +
                "                \"flightId\": \"4\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"unaccompaniedMinor\": false,\n" +
                "        \"sessionID\": \"01DSZNC252\",\n" +
                "      \"owener\": \"01DSZNC252\"\n" +
                "    }\n" +
                "}\n" +
                "\n";

        ObjectMapper mapper = new ObjectMapper();

        CslServingGetPnrResponse response = mapper.readValue(json, CslServingGetPnrResponse.class);

        assertThat(response.getStatus()).isEqualTo("SUCCESS");
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class VehicleDetails {
    private String make;
    private String model;
}