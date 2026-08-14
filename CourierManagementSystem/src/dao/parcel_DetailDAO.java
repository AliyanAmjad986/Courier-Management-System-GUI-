package dao;

public interface parcel_DetailDAO  {
void parcel_detail_insert();
void parcel_detail_fetch();
void total_parcel_fetch();
void total_pending_fetch();
void total_in_transist();
void total_in_delivered();
void total_in_delivery_failed();
void parcel_detail_update();
}
