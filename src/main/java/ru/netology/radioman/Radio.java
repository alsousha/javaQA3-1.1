package ru.netology.radioman;

/*
Номер текущей радиостанции изменяется в пределах от 0 до 9
Если текущая радиостанция - 9 и клиент нажал на кнопку next (следующая) на пульте, то текущей должна стать 0-ая
Если текущая радиостанция - 0 и клиент нажал на кнопку prev (предыдущая) на пульте, то текущей должна стать 9-ая
Клиент должен иметь возможность выставлять номер радиостанции с цифрового пульта (вводя числа 0 - 9)
* */
public class Radio {
    private int numberOfActualRadioStation = 0;
    private int volume = 0;
    private int maxCountRadiostation=10;

    private int minVolume=0;
    private int maxVolume=100;

    public Radio() {
    }
    public Radio(int maxCountRadiostation) {
        this.maxCountRadiostation = maxCountRadiostation;
    }

    public int getMaxCountRadiostation() {
        return maxCountRadiostation;
    }

    public int getNumberOfActualRadioStation() {
        return numberOfActualRadioStation;
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


    public int getMinVolume() {
        return minVolume;
    }

    public int getMaxVolume() {
        return maxVolume;
    }
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
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
