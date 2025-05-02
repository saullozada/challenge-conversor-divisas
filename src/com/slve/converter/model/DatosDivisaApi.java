package com.slve.converter.model;

public record DatosDivisaApi(String time_last_update_utc,
                             String base_code,
                             String target_code,
                             double conversion_rate) {
}
