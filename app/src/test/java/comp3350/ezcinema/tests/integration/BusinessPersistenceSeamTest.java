package comp3350.ezcinema.tests.integration;

        import junit.framework.TestCase;

        import java.util.ArrayList;
        import static org.junit.Assert.*;
        import comp3350.ezcinema.application.Main;
        import comp3350.ezcinema.application.Services;
        import comp3350.ezcinema.business.AccessMT;
        import comp3350.ezcinema.business.AccessMovie;
        import comp3350.ezcinema.business.AccessSeat;
        import comp3350.ezcinema.business.AccessTheater;
        import comp3350.ezcinema.business.ManageTickets;
        import comp3350.ezcinema.business.SortMovie;
        import comp3350.ezcinema.business.SortTheater;
        import comp3350.ezcinema.objects.MT;
        import comp3350.ezcinema.objects.Movie;
        import comp3350.ezcinema.objects.Theater;


        import comp3350.ezcinema.objects.Ticket;
        import comp3350.ezcinema.persistence.DataAccess;
        import comp3350.ezcinema.tests.persistence.DataAccessStub;


public class BusinessPersistenceSeamTest extends TestCase {

    //loop with one database then the next

    public void testAccessMovie() {

        AccessMovie accessorM;
        ArrayList list;
        String[] names;
        double[] ratings;
        String[] genres;


        int dbSwitch = 0;
        while (dbSwitch < 2) {
            Services.closeDataAccess();
            System.out.println("\nStarting Integration test of AccessMovie to persistence");
            if (dbSwitch == 0) {
                System.out.println("\nTesting on SQL DB");
                Services.createDataAccess(Main.dbName);
            } else {
                System.out.println("\nTesting on Stub");
                Services.createDataAccess(new DataAccessStub());
            }


            accessorM = new AccessMovie();
            list = new ArrayList<Movie>();
            accessorM.getMovies(list);

            names = new String[]{"Ferdinand", "Fifty Shades Freed", "Jumangi: Welcome to the Jungle", "Peter Rabbit", "Red Sparrow", "Tomb Raider", "Unforgettable", "Winchester"};
            ratings = new double[]{6.7, 6.4, 5.8, 5.6, 6.7, 8.9, 5.0, 2.8};
            genres = new String[]{"Family", "Family", "Thriller", "Family", "Horror", "Thriller", "Thriller", "Horror"};

            System.out.println("Whether the list is/isn't null and is not returned empty");

            assertNull(accessorM.getMovies((null)));
            assertNotNull(list);
            assertNotEquals(0, list.size());

            System.out.println("Test that the contents of the list are correct, alphabetical order");
            Movie testMovie;

            //make sure they're the same size
            assertEquals(names.length, list.size());

            int n = 0;
            while (n < list.size()) {
                testMovie = (Movie) list.get(n);

                assertEquals(names[n], testMovie.getMovieName());

                assertEquals(genres[n], testMovie.getGenre());

                assertEquals(ratings[n], testMovie.getMovieRating());

                n++;
            }

            dbSwitch++;
        }

    }

    public void testAccessMT() {

        AccessMT accessorMT;
        AccessTheater accessorT;
        AccessMovie accessorM;
        ArrayList mlist;
        ArrayList tlist;
        String[] mNames;
        String[] tNames;
        String[] showtimesArray;

        MT mt;
        Movie movie;
        Theater theater;

        int dbSwitch = 0;
        while (dbSwitch < 2) {
            Services.closeDataAccess();
            System.out.println("\nStarting Integration test of AccessMT to persistence");
            if (dbSwitch == 0) {
                System.out.println("\nTesting on SQL DB");
                Services.createDataAccess(Main.dbName);
            } else {
                System.out.println("\nTesting on Stub");
                Services.createDataAccess(new DataAccessStub());
            }

            accessorM = new AccessMovie();
            mlist = new ArrayList<Movie>();
            accessorM.getMovies(mlist);
            accessorT = new AccessTheater();
            tlist = new ArrayList<Theater>();
            accessorT.getTheaters(tlist);

            accessorMT = new AccessMT();

            mNames = new String[]{"Ferdinand", "Fifty Shades Freed", "Jumangi: Welcome to the Jungle", "Peter Rabbit", "Red Sparrow", "Tomb Raider", "Unforgettable", "Winchester"};
            tNames = new String[]{"Cinema City Northgate", "Cineplex Odeon McGillivray Cinemas", "Famous Players Kildonan Place Cinemas", "Scotiabank Theatre Winnipeg", "SilverCity St.Vital Cinemas"};

            showtimesArray = new String[]{"[10:40, 14:20, 19:50]", "[11:25, 15:40, 19:35]", "[15:30, 19:20, 22:50]", "[13:30, 16:40, 21:30]", "[14:50, 18:30, 21:50]", "[13:20, 16:50, 19:10, 22:00]", "[12:00, 15:20, 19:40]", "[13:30, 17:40, 20:25]", "[14:40, 18:00, 21:20]", "[14:00, 17:40, 20:30, 23:40]",
                    "[13:20, 16:50, 19:10, 22:00]", "[13:30, 17:40, 20:25]", "[14:00, 17:40, 20:30, 23:40]", "[14:40, 18:00, 21:20]", "[12:00, 15:20, 19:40]", "[14:40, 18:00, 21:20]", "[14:40, 17:40, 20:30, 23:40]",
                    "[12:00, 15:20, 19:40]", "[13:20, 16:50, 19:10, 22:00]", "[13:30, 17:40, 20:25]", "[14:10, 19:50, 22:30]", "[15:30, 19:50, 21:30]", "[13:40, 17:00, 23:10]", "[15:00, 18:10, 21:50]", "[11:10, 14:20, 20:30]", "[12:00, 16:30, 20:50]",
                    "[14:20, 17:50, 21:20]", "[14:40, 19:20, 23:30]", "[13:30, 14:20, 20:45]", "[15:45, 18:30, 21:40]", "[12:20, 15:30, 18:10]", "[13:00, 17:30, 21:20]", "[13:00, 18:00, 21:00]", "[12:30, 16:20, 21:00]", "[14:50, 18:40, 21:50]", "[14:00, 17:40, 20:30, 23:40]", "[14:40, 18:00, 21:20]",
                    "[13:20, 16:50, 19:10, 22:00]", "[13:30, 17:40, 20:25]", "[12:00, 15:20, 19:40]"};


            System.out.println("Test That the lists aren't null or empty");
            assertNotNull(mlist);
            assertNotEquals(0, mlist.size());

            assertNotNull(tlist);
            assertNotEquals(0, tlist.size());


            System.out.println("Test that the MT's are fetched properly");

            //nested for loop to cycle though theaters and movies to fetch MT objects

            mt = accessorMT.getMT(null, null);
            assertNull(mt);

            for (int i = 0; i < mNames.length; i++) {
                for (int k = 0; k < tNames.length; k++) {
                    movie = (Movie) mlist.get(i);
                    theater = (Theater) tlist.get(k);
                    mt = accessorMT.getMT(movie, theater);

                    //only if the movie-theater pair exists
                    if (mt != null) {
                        assertEquals(mNames[i], mt.getMovieName());

                        assertEquals(tNames[k], mt.getTheaterName());
                    }
                }
            }


            System.out.println("Test that the MT's have the proper showtimes");

            ArrayList<String> showtimes;

            //nested for loop to cycle though theaters and movies to check the showtimes in the MT objects
            int n = 0;
            for (int i = 0; i < mNames.length; i++) {
                for (int k = 0; k < tNames.length; k++) {
                    movie = (Movie) mlist.get(i);
                    theater = (Theater) tlist.get(k);
                    mt = accessorMT.getMT(movie, theater);

                    //only if the movie-theater pair exists
                    if (mt != null) {

                        showtimes = mt.getShowtime();

                        assertEquals(showtimesArray[n], showtimes.toString());
                        n++;
                    }
                }
            }


            dbSwitch++;
        }
    }

    public void testAccessTheater() {

        AccessTheater accessor;
        ArrayList list;
        String [] names;
        String [] addresses;

        int dbSwitch = 0;
        while (dbSwitch < 2) {
            Services.closeDataAccess();
            System.out.println("\nStarting Integration test of AccessTheater to persistence");
            if (dbSwitch == 0) {
                System.out.println("\nTesting on SQL DB");
                Services.createDataAccess(Main.dbName);
            } else {
                System.out.println("\nTesting on Stub");
                Services.createDataAccess(new DataAccessStub());
            }

            accessor = new AccessTheater();
            list = new ArrayList<Theater>();
            accessor.getTheaters(list);

            names = new String[]{"Cinema City Northgate", "Cineplex Odeon McGillivray Cinemas", "Famous Players Kildonan Place Cinemas", "Scotiabank Theatre Winnipeg", "SilverCity St.Vital Cinemas"};
            addresses = new String[]{"1399 McPhillips Street", "2190 McGillivray Blvd", "1555 Regent Avenue West", "817 St.James Street", "160-1225 St.Mary's Road, Winnipeg"};


            System.out.print("Whether the list is/isn't null and is not returned empty");
            assertNull(accessor.getTheaters((null)));
            assertNotNull(list);
            assertNotEquals(0, list.size());


            System.out.print("Test that the contents of the list are correct, alphabetical order");
            Theater testTheater;

            //make sure they're the same size
            assertEquals(names.length, list.size());

            int n = 0;
            while (n < list.size()) {
                testTheater = (Theater) list.get(n);

                assertEquals(names[n], testTheater.getTheaterName());
                assertEquals(addresses[n], testTheater.getTheaterAddress());

                n++;
            }

            dbSwitch++;
        }
    }

    public void testAccessSeats() {

        AccessMT accessorMT;
        AccessSeat accessorST;
        DataAccess dataAccess;
        MT testMT, testMT2;


        int dbSwitch = 0;
        while (dbSwitch < 2) {
            Services.closeDataAccess();
            System.out.println("\nStarting Integration test of AccessSeats to persistence");
            if (dbSwitch == 0) {
                System.out.println("\nTesting on SQL DB");
                Services.createDataAccess(Main.dbName);
            } else {
                System.out.println("\nTesting on Stub");
                Services.createDataAccess(new DataAccessStub());
            }


            accessorMT = new AccessMT();
            accessorST = new AccessSeat();

            dataAccess = Services.getDataAccess(Main.dbName);

            testMT = accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("Cinema City Northgate", "1399 McPhillips Street"));

            testMT2 = accessorMT.getMT(new Movie("Jumangi: Welcome to the Jungle", "Four teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game.", "Thriller", 5.8)
                    ,new Theater( "Cinema City Northgate","1399 McPhillips Street"));

            //check with null info
            assertEquals(-1, dataAccess.countRemain(null, "13:20"));
            assertEquals(-1, dataAccess.countRemain(testMT, null));
            assertEquals(-1, dataAccess.countRemain(null, null));


            //if the  information is Wrong  (improve the error handling of he sql in the method)
            assertEquals(0, dataAccess.countRemain(testMT, "wrong"));


            //count the current seats, all empty
            assertEquals(25, dataAccess.countRemain(testMT, "13:20"));


            //update 2 seats separately and check
            dataAccess.updateStatus(testMT, "13:20", 0, 0);
            assertEquals(24, dataAccess.countRemain(testMT, "13:20"));

            dataAccess.updateStatus(testMT, "13:20", 4, 4);
            assertEquals(23, dataAccess.countRemain(testMT, "13:20"));


            //update all of them, making no seats avaliable
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    dataAccess.updateStatus(testMT, "13:20", row, col);
                }
            }

            assertEquals(0, dataAccess.countRemain(testMT, "13:20"));


            ///FIX SQL ERRORS*********************************************************************

            //if either of the fields is null
            assertEquals(null, accessorST.getSeatTable(null, "13:20"));
            assertEquals(null, accessorST.getSeatTable(testMT2, null));

            //if the table doesn't exist, in the case of a wrong show time
            assertEquals(null, accessorST.getSeatTable(testMT2, "Wrong"));
            assertEquals(null, accessorST.getSeatTable(testMT2, "13:21"));
            assertEquals(null, accessorST.getSeatTable(testMT2, "#%@#@%"));


            //check the entries as they are, 0
            int[][] testTable = accessorST.getSeatTable(testMT2, "13:20");

            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    assertEquals(0, testTable[row][col]);
                }
            }


            //update all the entries, then check again
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    dataAccess.updateStatus(testMT2, "13:20", row, col);
                }
            }
            testTable = accessorST.getSeatTable(testMT2, "13:20");

            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    assertEquals(1, testTable[row][col]);
                }
            }


            ///try with improper details
            //bad showtime
            assertEquals("Error: Doesn't exist", dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("Cinema City Northgate", "1399 McPhillips Street")), "0", 0, 0));

            //bad theater name
            assertEquals("Error: Doesn't exist", dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("bad", "2190 McGillivray Blvd")), "12:00", 0, 0));

            //bad movie name
            assertEquals("Error: Doesn't exist", dataAccess.updateStatus(accessorMT.getMT(new Movie("bad", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("Scotiabank Theatre Winnipeg", "817 St.James Street")), "14:40", 0, 0));

            //bad seat location
            assertEquals("Error: Doesn't exist", dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("SilverCity St.Vital Cinemas", "160-1225 St.Mary's Road, Winnipeg")), "14:00", 7, 7));


            //Update the avaliable seats
            assertEquals(null, dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("Cineplex Odeon McGillivray Cinemas", "2190 McGillivray Blvd")), "12:00", 0, 0));

            assertEquals(null, dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("Famous Players Kildonan Place Cinemas", "1555 Regent Avenue West")), "13:30", 0, 0));

            assertEquals(null, dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("Scotiabank Theatre Winnipeg", "817 St.James Street")), "14:40", 0, 0));

            assertEquals(null, dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("SilverCity St.Vital Cinemas", "160-1225 St.Mary's Road, Winnipeg")), "14:00", 0, 0));


            //attempt to update them again
            assertEquals("Seat already claimed", dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("Cineplex Odeon McGillivray Cinemas", "2190 McGillivray Blvd")), "12:00", 0, 0));

            assertEquals("Seat already claimed", dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("Famous Players Kildonan Place Cinemas", "1555 Regent Avenue West")), "13:30", 0, 0));

            assertEquals("Seat already claimed", dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("Scotiabank Theatre Winnipeg", "817 St.James Street")), "14:40", 0, 0));

            assertEquals("Seat already claimed", dataAccess.updateStatus(accessorMT.getMT(new Movie("Fifty Shades Freed", "Anastasia and Christian get married, but Jack Hyde continues to threaten their relationship", "Family", 6.4)
                    , new Theater("SilverCity St.Vital Cinemas", "160-1225 St.Mary's Road, Winnipeg")), "14:00", 0, 0));

            dbSwitch++;
        }
    }

    public void testManageTickets() {


        ManageTickets accessorMT;

        Ticket ticket,testTicket;
        ArrayList tickets,listoftickets;


        int dbSwitch = 0;
        while (dbSwitch < 2) {
            Services.closeDataAccess();
            System.out.println("\nStarting Integration test of AccessSeats to persistence");
            if (dbSwitch == 0) {
                System.out.println("\nTesting on SQL DB");
                Services.createDataAccess(Main.dbName);
            } else {
                System.out.println("\nTesting on Stub");
                Services.createDataAccess(new DataAccessStub());
            }


            accessorMT = new ManageTickets();
            tickets = new ArrayList<Ticket>();
            listoftickets = new ArrayList<Ticket>();


            //test passing the database good and bad ticket creation info


            //test empty ticket
            assertEquals(0, accessorMT.createTicket(null, null, null, 0, 0));

            //test tickets missing info
            assertEquals(0, accessorMT.createTicket(null, "Cinema City Northgate", "10:40", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", null, "10:40", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Cinema City Northgate", null, 0, 0));
            assertEquals(0, accessorMT.createTicket(null, null, "10:40", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", null, null, 0, 0));
            assertEquals(0, accessorMT.createTicket(null, "Cinema City Northgate", null, 0, 0));


            //test incorrect info
            //movie name
            assertEquals(0, accessorMT.createTicket("Fifty Shades Freed", "Cinema City Northgate", "10:40", 0, 0));
            assertEquals(0, accessorMT.createTicket("Fifty Shades Freed", "Cineplex Odeon McGillivray Cinemas", "11:25", 0, 0));
            assertEquals(0, accessorMT.createTicket("Fifty Shades Freed", "Famous Players Kildonan Place Cinemas", "15:30", 0, 0));
            assertEquals(0, accessorMT.createTicket("Fifty Shades Freed", "Scotiabank Theatre Winnipeg", "13:30", 0, 0));
            assertEquals(0, accessorMT.createTicket("Fifty Shades Freed", "SilverCity St.Vital Cinemas", "14:50", 0, 0));


            //Theater name
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Cineplex Odeon McGillivray Cinemas", "10:40", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Famous Players Kildonan Place Cinemas", "11:25", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Scotiabank Theatre Winnipeg", "15:30", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "SilverCity St.Vital Cinemas", "13:30", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Cinema City Northgate", "14:50", 0, 0));

            //showtime
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Cinema City Northgate", "11:40", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Cineplex Odeon McGillivray Cinemas", "12:25", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Famous Players Kildonan Place Cinemas", "17:30", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Scotiabank Theatre Winnipeg", "14:30", 0, 0));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "SilverCity St.Vital Cinemas", "12:50", 0, 0));

            //row & col
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Cinema City Northgate", "10:40", 5, 5));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Cineplex Odeon McGillivray Cinemas", "11:25", 6, 6));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Famous Players Kildonan Place Cinemas", "15:30", 4, 7));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Scotiabank Theatre Winnipeg", "13:30", 7, 4));
            assertEquals(0, accessorMT.createTicket("Ferdinand", "SilverCity St.Vital Cinemas", "14:50", -1, -1));


            //test normal tickets, create 5 then grab them
            assertEquals(1, accessorMT.createTicket("Ferdinand", "Cinema City Northgate", "10:40", 0, 0));
            assertEquals(1, accessorMT.createTicket("Ferdinand", "Cineplex Odeon McGillivray Cinemas", "11:25", 0, 0));
            assertEquals(1, accessorMT.createTicket("Ferdinand", "Famous Players Kildonan Place Cinemas", "15:30", 0, 0));
            assertEquals(1, accessorMT.createTicket("Ferdinand", "Scotiabank Theatre Winnipeg", "13:30", 0, 0));
            assertEquals(1, accessorMT.createTicket("Ferdinand", "SilverCity St.Vital Cinemas", "14:50", 0, 0));


            //creating a ticket that's already there
            assertEquals(0, accessorMT.createTicket("Ferdinand", "Cinema City Northgate", "10:40", 0, 0));


            //testing of getting Sequential tickets
            accessorMT.getTicketsSequential(tickets);

            if (tickets.isEmpty()) {
                assertEquals(1, accessorMT.createTicket("Fifty Shades Freed", "Cinema City Northgate", "13:20", 0, 0));
                assertEquals(1, accessorMT.createTicket("Fifty Shades Freed", "Cineplex Odeon McGillivray Cinemas", "12:00", 0, 0));
                assertEquals(1, accessorMT.createTicket("Fifty Shades Freed", "Famous Players Kildonan Place Cinemas", "13:30", 0, 0));
                assertEquals(1, accessorMT.createTicket("Fifty Shades Freed", "Scotiabank Theatre Winnipeg", "14:40", 0, 0));
                assertEquals(1, accessorMT.createTicket("Fifty Shades Freed", "SilverCity St.Vital Cinemas", "14:00", 0, 0));

                listoftickets.add(new Ticket("Fifty Shades Freed", "Cinema City Northgate", "13:20", 0, 0));
                listoftickets.add(new Ticket("Fifty Shades Freed", "Cineplex Odeon McGillivray Cinemas", "12:00", 0, 0));
                listoftickets.add(new Ticket("Fifty Shades Freed", "Famous Players Kildonan Place Cinemas", "13:30", 0, 0));
                listoftickets.add(new Ticket("Fifty Shades Freed", "Scotiabank Theatre Winnipeg", "14:40", 0, 0));
                listoftickets.add(new Ticket("Fifty Shades Freed", "SilverCity St.Vital Cinemas", "14:00", 0, 0));

                accessorMT.getTicketsSequential(tickets);
            } else {
                listoftickets.add(new Ticket("Ferdinand", "Cinema City Northgate", "10:40", 0, 0));
                listoftickets.add(new Ticket("Ferdinand", "Cineplex Odeon McGillivray Cinemas", "11:25", 0, 0));
                listoftickets.add(new Ticket("Ferdinand", "Famous Players Kildonan Place Cinemas", "15:30", 0, 0));
                listoftickets.add(new Ticket("Ferdinand", "Scotiabank Theatre Winnipeg", "13:30", 0, 0));
                listoftickets.add(new Ticket("Ferdinand", "SilverCity St.Vital Cinemas", "14:50", 0, 0));
            }


            int[] testTicketLocation;
            int[] ticketLocation;
            for (int i = 0; i < listoftickets.size(); i++) {
                ticket = (Ticket) tickets.get(i);
                testTicket = (Ticket) listoftickets.get(i);

                assertEquals(testTicket.getMovieName(), ticket.getMovieName());
                assertEquals(testTicket.getTheaterName(), ticket.getTheaterName());
                assertEquals(testTicket.getShowTime(), ticket.getShowTime());

                testTicketLocation = testTicket.getSeatLocation();
                ticketLocation = ticket.getSeatLocation();

                assertEquals(testTicketLocation[0], ticketLocation[0]);
                assertEquals(testTicketLocation[1], ticketLocation[1]);
            }

            dbSwitch++;
        }
    }

    public void testSortMovies() {

        Movie movie;
        ArrayList<Movie> movies, sorted;
        AccessMovie accessorM;
        String [] nameOrder;
        double [] ratingOrder;
        String [] genres;


        int dbSwitch = 0;
        while (dbSwitch < 2) {
            Services.closeDataAccess();
            System.out.println("\nStarting Integration test of AccessSeats to persistence");
            if (dbSwitch == 0) {
                System.out.println("\nTesting on SQL DB");
                Services.createDataAccess(Main.dbName);
            } else {
                System.out.println("\nTesting on Stub");
                Services.createDataAccess(new DataAccessStub());
            }

            accessorM = new AccessMovie();
            movies = new ArrayList<Movie>();
            sorted = new ArrayList<Movie>();
            accessorM.getMovies(movies);

            nameOrder = new String[]{"Ferdinand", "Fifty Shades Freed", "Jumangi: Welcome to the Jungle", "Peter Rabbit", "Red Sparrow", "Tomb Raider", "Unforgettable", "Winchester"};
            ratingOrder = new double[]{8.9, 6.7, 6.7, 6.4, 5.8, 5.6, 5.0, 2.8};
            genres = new String[]{"Family", "Thriller", "Horror"};


            sorted = (ArrayList<Movie>) SortMovie.sortByName(null);

            assertNull(sorted);

            sorted = (ArrayList<Movie>) SortMovie.sortByName(movies);

            assertNotNull(sorted);

            for (int n = 0; n < sorted.size(); n++) {

                movie = (Movie) sorted.get(n);

                assertEquals(nameOrder[n], movie.getMovieName());
            }


            sorted = (ArrayList<Movie>) SortMovie.sortByRating(null);

            assertNull(sorted);

            sorted = (ArrayList<Movie>) SortMovie.sortByRating(movies);

            assertNotNull(sorted);

            for (int n = 0; n < sorted.size(); n++) {

                movie = (Movie) sorted.get(n);

                assertEquals(ratingOrder[n], movie.getMovieRating());
            }


            sorted = (ArrayList<Movie>) SortMovie.sortByGenre(null, null);

            assertNull(sorted);

            for (int i = 0; i < 3; i++) {
                sorted = SortMovie.sortByGenre(movies, genres[i]);

                assertNotNull(sorted);

                for (int n = 0; n < sorted.size(); n++) {

                    movie = (Movie) sorted.get(n);
                    assertEquals(genres[i], movie.getGenre());
                }
            }

            dbSwitch++;
        }
    }

    public void testSortTheaters() {


        AccessTheater accessor;
        ArrayList theaters, sorted;
        String [] namesOrder;
        Theater theater;

        int dbSwitch = 0;
        while (dbSwitch < 2) {
            Services.closeDataAccess();
            System.out.println("\nStarting Integration test of AccessSeats to persistence");
            if (dbSwitch == 0) {
                System.out.println("\nTesting on SQL DB");
                Services.createDataAccess(Main.dbName);
            } else {
                System.out.println("\nTesting on Stub");
                Services.createDataAccess(new DataAccessStub());
            }

            accessor = new AccessTheater();
            theaters = new ArrayList<Theater>();
            sorted = new ArrayList<Theater>();
            accessor.getTheaters(theaters);

            namesOrder = new String[]{"Cinema City Northgate", "Cineplex Odeon McGillivray Cinemas", "Famous Players Kildonan Place Cinemas", "Scotiabank Theatre Winnipeg", "SilverCity St.Vital Cinemas"};


            sorted = (ArrayList<Theater>) SortTheater.sortByName(null);

            assertNull(sorted);

            sorted = (ArrayList<Theater>) SortTheater.sortByName(theaters);

            assertNotNull(sorted);

            for (int n = 0; n < sorted.size(); n++) {

                theater = (Theater) sorted.get(n);

                assertEquals(namesOrder[n], theater.getTheaterName());
            }

        dbSwitch++;
        }

    }

}




