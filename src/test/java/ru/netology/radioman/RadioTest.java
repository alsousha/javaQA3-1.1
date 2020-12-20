package ru.netology.radioman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
//    Radio radio = new Radio();

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'numberRadiostation_11',11,11",
                    "'numberRadiostation_5',5,5",
                    "'numberRadiostation 20',20,20",
                    "'numberRadiostation 0',0,0",
            }
    )
    void createRadioWithConstructor(String text, int maxCountRadiostation, int expected) {
        Radio radio = new Radio(maxCountRadiostation);
        int actual = radio.getMaxCountRadiostation();
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'numberRadiostation',10"
            }
    )
    void createRadioWithDefaultConstructor(String text, int expected) {
        Radio radio = new Radio();
        int actual = radio.getMaxCountRadiostation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'maxCountRadioSation_20AndRadioStation_20',20,20,20",
                    "'maxCountRadioSation_20AndRadioStation_10',20,10,10",
                    "'maxCountRadioSation_0AndRadioStation_10',0,10,0",
                    "'maxCountRadioSation_0AndRadioStation_0',0,0,0",
            }
    )
    void setNumberOfActualRadioStationWithConstructor(String text, int maxCountRadioStation, int actualRadioStation, int expected) {

        Radio radio = new Radio(maxCountRadioStation);
        radio.setNumberOfActualRadioStation(actualRadioStation);
        int actual = radio.getNumberOfActualRadioStation();
        assertEquals(expected, actual);

    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'maxCountRadioSation_10AndRadioStation_5',10,5,5",
                    "'maxCountRadioSation_10AndRadioStation_10',10,10,10",
                    "'maxCountRadioSation_10AndRadioStation_0',10,0,0",
            }
    )
    void setNumberOfActualRadioStationWithDefaultConstructor(String text, int maxCountRadioStation, int actualRadioStation, int expected) {
        //Допускается ли конструкция if в тестах или лучше сделать два отдельных теста?
        if (maxCountRadioStation == 0) {
            Radio radio = new Radio();
            radio.setNumberOfActualRadioStation(actualRadioStation);
            int actual = radio.getNumberOfActualRadioStation();
            assertEquals(expected, actual);
        } else {
            Radio radio = new Radio(maxCountRadioStation);
            radio.setNumberOfActualRadioStation(actualRadioStation);
            int actual = radio.getNumberOfActualRadioStation();
            assertEquals(expected, actual);
        }
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'maxCountRadioSation_20AndRadioStation_5',5,20,6",
                    "'maxCountRadioSation_20AndRadioStation_20',20,20,0",
                    "'maxCountRadioSation_20AndRadioStation_10',10,20,11",
                    "'maxCountRadioSation_0AndRadioStation_0',0,0,0",
                    "'maxCountRadioSation_9AndRadioStation_9',9,9,0",
            }
    )
    void nextRadioStationWithConstructor(String text, int radioStation, int maxCountRadioStation, int expected) {
        Radio radio = new Radio(maxCountRadioStation);
        radio.setNumberOfActualRadioStation(radioStation);
        radio.next();
        int actual = radio.getNumberOfActualRadioStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'maxCountRadioSation_10AndRadioStation_5',5,6",
                    "'maxCountRadioSation_10AndRadioStation_0',0,1",
                    "'maxCountRadioSation_10AndRadioStation_10',10,0",
            }
    )
    void nextRadioStationWithDefaultConstructor(String text, int radioStation, int expected) {
        Radio radio = new Radio();
        radio.setNumberOfActualRadioStation(radioStation);
        radio.next();
        int actual = radio.getNumberOfActualRadioStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'maxCountRadioSation_20AndRadioStation_5',5,20,4",
                    "'maxCountRadioSation_20AndRadioStation_20',20,20,19",
                    "'maxCountRadioSation_20AndRadioStation_10',10,20,9",
                    "'maxCountRadioSation_20AndRadioStation_0',0,20,20",
                    "'maxCountRadioSation_0AndRadioStation_0',0,0,0",
                    "'maxCountRadioSation_9AndRadioStation_9',9,9,8",
            }
    )
    void prevRadioStationWithConstructor(String text, int radioStation, int maxCountRadioStation, int expected) {
        Radio radio = new Radio(maxCountRadioStation);
        radio.setNumberOfActualRadioStation(radioStation);
        radio.prev();
        int actual = radio.getNumberOfActualRadioStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'maxCountRadioSation_10AndRadioStation_5',5,4",
                    "'maxCountRadioSation_10AndRadioStation_0',0,10",
                    "'maxCountRadioSation_10AndRadioStation_9',9,8",
            }
    )
    void prevRadioStationWithDefaultConstructor(String text, int radioStation, int expected) {
        Radio radio = new Radio();
        radio.setNumberOfActualRadioStation(radioStation);
        radio.prev();
        int actual = radio.getNumberOfActualRadioStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'actualValue_50',0,100,50,51",
                    "'actualValue_0',0,100,0,1",
                    "'actualValue_99',0,100,99,100",
                    "'actualValue_100',0,100,100,100",
            }
    )
    void upperVolume(String text, int minValue, int maxValue, int actualValue, int expected) {
        Radio radio = new Radio();
        radio.setVolume(actualValue);
        radio.upperVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'actualValue_50',0,100,50,49",
                    "'actualValue_0',0,100,0,0",
                    "'actualValue_99',0,100,99,98",
                    "'actualValue_100',0,100,100,99",
            }
    )
    void lessVolume(String text, int minValue, int maxValue, int actualValue, int expected) {
        Radio radio = new Radio();
        radio.setVolume(actualValue);
        radio.lessVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }
}