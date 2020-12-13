package ru.netology.radioman;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'correct number(between 0-9)',5,5",
                    "'number 0',0,0",
                    "'number 9',9,9",
                    "'incorrect number(not between 0-9)',10,0",
                    "'incorrect number(negative)',-5,0",
            }
    )
    void setNumberOfActualRadioStation(String text, int number, int expected) {
        radio.setNumberOfActualRadioStation(number);
        int actual = radio.getNumberOfActualRadioStation();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'numberOfRadioStation between 0-9',5,6",
                    "'number 0',0,1",
                    "'number 9',9,0",
            }
    )
    void next(String text, int radiostation, int expected) {
        radio.setNumberOfActualRadioStation(radiostation);
        radio.next();
        int actual = radio.getNumberOfActualRadioStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'numberOfRadioStation between 0-9',5,4",
                    "'number 0',0,9",
                    "'number 9',9,8",
            }
    )
    void prev(String text, int radiostation, int expected) {
        radio.setNumberOfActualRadioStation(radiostation);
        radio.prev();
        int actual = radio.getNumberOfActualRadioStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'value between 0-9',5,6",
                    "'value 0',0,1",
                    "'value 10',10,0",
            }
    )
    void upperVolume(String text, int value, int expected) {
        radio.setVolume(value);
        radio.upperVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(
            value = {
                    "'value between 0-9',5,4",
                    "'value 0',0,10",
                    "'value 10',10,9",
            }
    )
    void lessVolume(String text, int value, int expected) {
        radio.setVolume(value);
        radio.lessVolume();
        int actual = radio.getVolume();
        assertEquals(expected, actual);
    }
}