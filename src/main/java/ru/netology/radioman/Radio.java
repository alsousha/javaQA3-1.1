package ru.netology.radioman;

/*
Номер текущей радиостанции изменяется в пределах от 0 до 9
Если текущая радиостанция - 9 и клиент нажал на кнопку next (следующая) на пульте, то текущей должна стать 0-ая
Если текущая радиостанция - 0 и клиент нажал на кнопку prev (предыдущая) на пульте, то текущей должна стать 9-ая
Клиент должен иметь возможность выставлять номер радиостанции с цифрового пульта (вводя числа 0 - 9)
* */
public class Radio {
    private int numberOfActualRadioStation=0;
    private int volume = 0;

    public int getNumberOfActualRadioStation() {
        return numberOfActualRadioStation;
    }

    public void setNumberOfActualRadioStation(int number) {
        if(number>=0 && number<10) this.numberOfActualRadioStation = number;
    }

    public void next(){
        int radiostation = this.getNumberOfActualRadioStation();
        if(radiostation == 9){
            setNumberOfActualRadioStation(0);
        } else {
            setNumberOfActualRadioStation(++radiostation);
        }
    }
    public void prev(){
        int radiostation = this.getNumberOfActualRadioStation();
        if(radiostation == 0) setNumberOfActualRadioStation(9);
        else setNumberOfActualRadioStation(--radiostation);
    }

    public int getVolume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void upperVolume(){
        int volume = this.getVolume();
        if (volume==10) setVolume(0);
        else setVolume(++volume);
    }
    public void lessVolume(){
        int volume = this.getVolume();
        if (volume==0) setVolume(10);
        else setVolume(--volume);
    }

}
