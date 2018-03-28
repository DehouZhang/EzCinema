EZCinema

Development team (Group F)
-Dehou Zhang
-Qin Yang
-Shawn Cooper
-Randall Romanow
-Dow Griffith

repository location
https://github.com/DehouZhang/EzCinema

Packages
-comp3350.ezcinema.objects
	-Iteration 1
	-Movie.java
	-Theater.java
	Iteration2
	-MT.java
	Iteration3
	-Seat.java
	-Ticket.java
-comp3350.ezcinema.business
	-AccessMovie.java
	-AccessTheater.java
	-SortMovie.java
	-SortTheater.java
	Iteration 2
	-AccessMT.java
	Iteration3
	-AccessSeat
	-CalculateTax
	-Validateinput
	-ManageTickets

-comp3350.ezcinema.application
	Iteration 1
	-Main.java
	-Services.java
-comp3350.ezcinema.persistence
	Iteration 1
	-DataAccessStub.java
	Iteration 2
	-DataAccess.java
	-DataAccessObject.java
-comp3350.ezcinema.presentation
	-HomeActivity.java
	-MovieActivity.java
	-MoveDescActivity.java
	-TheaterActivity.java
	Iteration 2
	-CheckoutActivity.java
	-Confirmation.java
	-FragmentCredit.java
	-FragementScene.java
	-FragementPalPal.java
	-MovieSelectTheaterActivity.java
	-MovieSelectTheaterAdapter.java
	-TheaterSelectMovieActivity.java
	-TheaterSelectMovieAdapter.java
	-TicketActivity.java
	Iteration3
	-SeatAdapter
	-SearSelectActivity
	-TicketBoughtActivity

Features
Iteration 1
-List of Movies available
	-Found under the movie button on the main screen
	-Sorting methods for the movies that are active
		-Can be used by click the corresponding button
		-Genre
		-Name
		-Rating
-Movie Details Page
	-Found by "clicking" a movie in the list
-List of Theaters available
	-Found under the theater button on the main screen
	-Sorting methods for the theaters that are active
		-Can be used by click the corresponding button
		-Name
		-Address 
		

Iteration 2
-Buying a ticket for a movie
	-Selecting a movie from the movie list will allow a user to choose a theater they want to see the movie at
	-Selecting a theater will bring the user to a page to select a showtime and the amount of tickets to purchase
	-Clicking confirm will bring the user to a payment option page
	-after "purchasing" a ticket the user will be brought to a page that has ticket info on it and a QR code that could be scanned 		at a theater
 
 	-Alternately a user could select a theater from the theater list
	-This will bring them to a list of movie playing at that theater
	-After they select a movie they will be brought to the showtime and tickets amount selection page

Iteration 3
	-App now stores tickets purchased and allows for viewing all tickets purchased
		-Page can be found from the my tickets page
		-clicking on tickets in this page brings you to the ticket display page
	-Integrated seat selection into ticket purchasing process
		-To select a seat touch a green box with numbers in it
		-Once a ticket is purchased that seat is reserved
	-Updated GUI to look presentable

Log is in the repository

