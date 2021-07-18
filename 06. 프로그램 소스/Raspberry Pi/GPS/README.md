## GPS 데몬 및 유틸리티 프로그램 설치
```Shell
pi@raspberrypi ~ $ sudo apt-get install gpsd gpsd-clients 
pi@raspberrypi ~ $ sudo -H pip3 install gps3
```

## gpsd 데몬 실행

USB 포트인 경우 /dev/ttyUSB0 장치 파일 사용
```Shell
pi@raspberrypi ~ $ sudo gpsd /dev/ttyUSB0 -F /var/run/gpsd.sock
```
 
