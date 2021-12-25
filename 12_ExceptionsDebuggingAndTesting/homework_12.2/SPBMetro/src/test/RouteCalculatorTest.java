import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {

    // Минское метро
    // Line1                line2          Line3
    //1                     6              11
    //2                     7              12
    //3                     8 Line2(4)     13
    //4 Line2(8)            9              14 line2(10)
    //5                     10 line3(14)   15

    List<Station> myRoute = new ArrayList<>();

    Station s1;
    Station s2;
    Station s3;
    Station s4;
    Station s5;
    Station s6;
    Station s7;
    Station s8;
    Station s9;
    Station s10;
    Station s11;
    Station s12;
    Station s13;
    Station s14;
    Station s15;

    List<Station> actualShortestRoute = new ArrayList<>();
    List<Station> expectedShortestRoute_1 = new ArrayList<>();
    List<Station> expectedShortestRoute_2 = new ArrayList<>();
    List<Station> expectedShortestRoute_3 = new ArrayList<>();

    StationIndex myStationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(myStationIndex);

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        /*Три линии метро*/

        Line first = new Line(1, "Московская");
        Line second = new Line(2, "Автозаводская");
        Line third = new Line(3, "Зеленолужская");

        /*Станции*/

        s1 = new Station("Институт культуры", first);
        s2 = new Station("Московская", first);
        s3 = new Station("Восток", first);
        s4 = new Station("Уручье", first);
        s5 = new Station("Малиновка", first);

        first.addStation(s1);
        first.addStation(s2);
        first.addStation(s3);
        first.addStation(s4);
        first.addStation(s5);

        s6 = new Station("Пушкинская", second);
        s7 = new Station("Немига", second);
        s8 = new Station("Купаловская", second);
        s9 = new Station("Партизанская", second);
        s10 = new Station("Тракторный завод", second);

        second.addStation(s6);
        second.addStation(s7);
        second.addStation(s8);
        second.addStation(s9);
        second.addStation(s10);

        s11 = new Station("Зеленый луг", third);
        s12 = new Station("Ивана Мележа", third);
        s13 = new Station("Комаровская", third);
        s14 = new Station("Ковальская слобода", third);
        s15 = new Station("Слуцки гастинец", third);

        third.addStation(s11);
        third.addStation(s12);
        third.addStation(s13);
        third.addStation(s14);
        third.addStation(s15);

        /* Формируем тестовое метро */

        myStationIndex.addLine(first);
        myStationIndex.addLine(second);
        myStationIndex.addLine(third);

        myStationIndex.addStation(s1);
        myStationIndex.addStation(s2);
        myStationIndex.addStation(s3);
        myStationIndex.addStation(s4);
        myStationIndex.addStation(s5);
        myStationIndex.addStation(s6);
        myStationIndex.addStation(s7);
        myStationIndex.addStation(s8);
        myStationIndex.addStation(s9);
        myStationIndex.addStation(s10);
        myStationIndex.addStation(s11);
        myStationIndex.addStation(s12);
        myStationIndex.addStation(s13);
        myStationIndex.addStation(s14);
        myStationIndex.addStation(s15);

        List<Station> connectionStations1 = new ArrayList<>();
        List<Station> connectionStations2 = new ArrayList<>();
        connectionStations1.add(s4);
        connectionStations1.add(s8);
        connectionStations2.add(s10);
        connectionStations2.add(s14);

        myStationIndex.addConnection(connectionStations1);
        myStationIndex.addConnection(connectionStations2);

        /*Формируем оптимальные пути*/

        myRoute.add(s1);
        myRoute.add(s2);
        myRoute.add(s6);
        myRoute.add(s7);

        expectedShortestRoute_1.add(s2);
        expectedShortestRoute_1.add(s3);
        expectedShortestRoute_1.add(s4);
        expectedShortestRoute_1.add(s5);

        expectedShortestRoute_2.add(s8);
        expectedShortestRoute_2.add(s9);
        expectedShortestRoute_2.add(s10);
        expectedShortestRoute_2.add(s14);
        expectedShortestRoute_2.add(s13);

        expectedShortestRoute_3.add(s1);
        expectedShortestRoute_3.add(s2);
        expectedShortestRoute_3.add(s3);
        expectedShortestRoute_3.add(s4);
        expectedShortestRoute_3.add(s8);
        expectedShortestRoute_3.add(s9);
        expectedShortestRoute_3.add(s10);
        expectedShortestRoute_3.add(s14);
        expectedShortestRoute_3.add(s13);
        expectedShortestRoute_3.add(s12);
        expectedShortestRoute_3.add(s11);

        /*Первый тест*/
    }
        public void testGetShortestRoute_OnTheLine () {
            routeCalculator = new RouteCalculator(myStationIndex);
            actualShortestRoute = routeCalculator.getShortestRoute(s2, s5);
            assertEquals(expectedShortestRoute_1, actualShortestRoute);
        }

        public void testGetShortestRoute_WithOneConnection () {
            routeCalculator = new RouteCalculator(myStationIndex);
            actualShortestRoute = routeCalculator.getShortestRoute(s8, s13);
            assertEquals(expectedShortestRoute_2, actualShortestRoute);
        }

        public void testGetShortestRoute_WithTwoConnections () {
            routeCalculator = new RouteCalculator(myStationIndex);
            actualShortestRoute = routeCalculator.getShortestRoute(s1, s11);
            assertEquals(expectedShortestRoute_3, actualShortestRoute);
        }

        /*Второй тест*/

        public void testCalculateDuration(){

            double expected = 8.5;
            double actual = RouteCalculator.calculateDuration(myRoute);

            assertEquals(expected,actual);
        }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
