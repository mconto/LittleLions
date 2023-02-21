package com.littleLions.co.domain.enums;

public enum Localizaciones {

    BARRIOS_UNIDOS(-74.084, 4.6664),
    ENGATIVA(-74.1072, 4.7071000000000005),
    SUMAPAZ(-74.315224, 4.034746),
    TEUSAQUILLO(-74.0938, 4.6448),
    LA_CANDELARIA(-74.0739, 4.5939),
    SANTA_FE(-74.0298, 4.5963),
    SUBA(-74.0824, 4.7652),
    FONTIBON(-74.1479, 4.6832),
    LOS_MÁRTIRES(-74.0913, 4.603),
    SAN_CRISTOBAL(-74.0883, 4.5463000000000005),
    USME(-74.1033, 4.4766),
    PUENTE_ARANDA(-74.1227, 4.6149000000000004),
    USAQUEN(-74.0312, 4.7485),
    BOGOTA(-74.08175, 4.60971),
    BOSA(-74.1945, 4.6305),
    CIUDAD_BOLIVAR(-74.1539, 4.5066),
    RAFAEL_URIBE_URIBE(-74.1164, 4.5653),
    KENNEDY(-74.1573, 4.6268),
    CHAPINERO(-74.0467, 4.6569),
    TUNJUELITO(-74.1407, 4.5875),
    ANTONIO_NARINO(-74.1009, 4.5486);


    private final double longitud;
    private final double latitud;

    Localizaciones(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }


}

