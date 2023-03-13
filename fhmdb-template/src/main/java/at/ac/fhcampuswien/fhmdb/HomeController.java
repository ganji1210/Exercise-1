package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.enums.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import at.ac.fhcampuswien.fhmdb.ui.MovieCell;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class HomeController implements Initializable {
    @FXML
    public JFXButton searchBtn;

    @FXML
    public TextField searchField;

    @FXML
    public JFXListView movieListView;

    @FXML
    public JFXComboBox genreComboBox;

    @FXML
    public JFXButton sortBtn;

    public List<Movie> allMovies = Movie.initializeMovies();

    private final ObservableList<Movie> observableMovies = FXCollections.observableArrayList();   // automatically updates corresponding UI elements when underlying data changes

    private  FilteredList<Movie> filteredMovies;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        observableMovies.addAll(allMovies); // add dummy data to observable list

        filteredMovies  = new FilteredList<>(observableMovies);

        // initialize UI stuff
        movieListView.setItems(filteredMovies);   // set data of observable list to list view

        movieListView.setCellFactory(movieListView -> new MovieCell()); // use custom cell factory to display data

        // add genre filter items with genreComboBox.getItems().addAll(...)

        genreComboBox.getItems().add("NONE");

        genreComboBox.getItems().addAll(Genre.values());

        genreComboBox.setPromptText("Filter by Genre");

        // TODO add event handlers to buttons and call the regarding methods
        // either set event handlers in the fxml file (onAction) or add them here

        searchBtn.setOnAction(actionEvent -> {

            String searchText = searchField.getText();
            filteredMovies.setPredicate(s -> (s.getTitle().toLowerCase(Locale.ROOT).contains(searchText.toLowerCase(Locale.ROOT)) || s.getDescription().toLowerCase(Locale.ROOT).contains(searchText.toLowerCase(Locale.ROOT)))
                    && (genreComboBox.getValue() == null || genreComboBox.getValue().equals("NONE") || s.getGenres().stream().anyMatch(g -> g.equals(genreComboBox.getValue())))

            );

            movieListView.refresh();

        });

        // Sort button example:

        Comparator<Movie>movieComparator = Comparator.comparing(Movie::getTitle);

        sortBtn.setOnAction(actionEvent -> {
            if(sortBtn.getText().equals("Sort (asc)")) {
                // sort observableMovies ascending

                observableMovies.sort(movieComparator);

                sortBtn.setText("Sort (desc)");

            } else {
                // sort observableMovies descending

                observableMovies.sort(movieComparator.reversed());

                sortBtn.setText("Sort (asc)");
            }
        });

    }

}