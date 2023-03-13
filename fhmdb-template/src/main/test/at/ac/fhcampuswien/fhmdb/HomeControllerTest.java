package at.ac.fhcampuswien.fhmdb;

import static org.junit.jupiter.api.Assertions.*;
import at.ac.fhcampuswien.fhmdb.controller.HomeController;
import at.ac.fhcampuswien.fhmdb.models.Genre;
import at.ac.fhcampuswien.fhmdb.models.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HomeControllerTest {


    private HomeController homeController;

    @BeforeEach
    void setUp() {
        homeController = new HomeController();
    }



}