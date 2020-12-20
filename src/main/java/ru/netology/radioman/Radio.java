package ru.netology.radioman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Radio {
    private int numberOfActualRadioStation = 0;
    private int volume = 0;
    private int maxCountRadiostation=10;

    private int minVolume=0;
    private int maxVolume=100;

    Radio(int maxCountRadiostation){
        this.maxCountRadiostation=maxCountRadiostation;
    }

    public void setNumberOfActualRadioStation(int number) {
        if (number <= maxCountRadiostation) this.numberOfActualRadioStation = number;
    }

    public void next() {
        int radiostation = this.getNumberOfActualRadioStation();
        if (radiostation == this.maxCountRadiostation) {
            setNumberOfActualRadioStation(0);
        } else {
            setNumberOfActualRadioStation(++radiostation);
        }
    }

    public void prev() {
        int radiostation = this.getNumberOfActualRadioStation();
        if (radiostation == 0) setNumberOfActualRadioStation(this.maxCountRadiostation);
        else setNumberOfActualRadioStation(--radiostation);
    }

    public void upperVolume() {
        int volume = this.getVolume();
        if (volume == this.maxVolume) setVolume(this.maxVolume);
        else setVolume(++volume);
    }

    public void lessVolume() {
        int volume = this.getVolume();
        if (volume == this.minVolume) setVolume(this.minVolume);
        else setVolume(--volume);
    }


}
