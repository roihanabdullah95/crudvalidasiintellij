package com.project.tokoonline.dto;

public class TiketKeretaDTO {
//    Buat field
    private String nama;
    private String krl;
    private String departure;
    private String end_departure;
// Cetak sagetter setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKrl() {
        return krl;
    }

    public void setKrl(String krl) {
        this.krl = krl;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getEnd_departure() {
        return end_departure;
    }

    public void setEnd_departure(String end_departure) {
        this.end_departure = end_departure;
    }
}
