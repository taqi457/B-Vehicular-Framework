#ifndef DATA_H__
#define DATA_H__

enum {
  AM_RSSIMSG = 10,
  //AM_BLINKTORADIO = 6
  
};

typedef nx_struct Data{
  nx_int16_t rssi;
  nx_uint8_t car_id;
  nx_uint8_t node_id;
  nx_uint8_t direction;
} Data;

#endif //DATA_H__