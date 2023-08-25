package com.kentoes.kpi.webflux.dto.commons;

import org.springframework.http.HttpStatus;

public interface IGlobalMessage {
    String OK_MESSAGE = "data found";
    String NOT_FOUND_MESSAGE = "data not found";
    String SAVE_MESSAGE = "data saved successfully";
    String UPDATE_MESSAGE = "data updated successfully";
    String DELETE_MESSAGE = "data deleted successfully";
    String NOT_DELETED_MESSAGE = "data not deleted";
    HttpStatus OK_STATUS = HttpStatus.OK;
    HttpStatus NO_CONTENT_STATUS = HttpStatus.NO_CONTENT;
    HttpStatus SAVE_STATUS = HttpStatus.CREATED;
    HttpStatus UPDATE_STATUS = HttpStatus.ACCEPTED;
    HttpStatus DELETE_STATUS = HttpStatus.ACCEPTED;
    HttpStatus BAD_REQUEST_STATUS = HttpStatus.BAD_REQUEST;
    HttpStatus CONFLICT_STATUS = HttpStatus.CONFLICT;
    HttpStatus INTERNAL_SERVER_ERROR_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    String UNKNOWN_GRADE = "Unknown Grade";
    String GRADE_ALREADY_EXIST = "Grade already exist";
    String UNKNOWN_INDIKATOR = "Unknown Indikator";
    String INDIKATOR_ALREADY_EXIST = "Indikator already exist";
    String INDIKATOR_HAS_URAIAN_INDIKATOR = "Indikator has uraian indikator";
    String UNKNOWN_KPI = "Unknown KPI";
    String KPI_ALREADY_EXIST = "KPI already exist";
    String KPI_HAS_INDIKATOR = "KPI has indikator";
    String KPI_DELETED = "KPI deleted";
    String UNKNOWN_LEVEL = "Unknown Level";
    String LEVEL_ALREADY_EXIST = "Level already exist";
    String UNKNOWN_PERILAKU = "Unknown Perilaku";
    String PERILAKU_ALREADY_EXIST = "Perilaku already exist";
    String UNKNOWN_PROFESI = "Unknown Profesi";
    String PROFESI_ALREADY_EXIST = "Profesi already exist";
    String UNKNOWN_URAIAN_INDIKATOR = "Unknown Uraian Indikator";
    String URAIAN_INDIKATOR_ALREADY_EXIST = "Uraian Indikator already exist";
    String UNKNOWN_KPI_PEGAWAI = "Unknown KPI Pegawai";
    String KPI_PEGAWAI_ALREADY_EXIST = "KPI Pegawai already exist";
    String UNKNOWN_LEVEL_PERILAKU = "Unknown Level Perilaku";
    String LEVEL_PERILAKU_ALREADY_EXIST = "Level Perilaku already exist";
    static String UNKNOWN_TRANS_KPI = "Unknown Trans KPI";
    String UNKNOWN_TRANS_KPI_URAIAN = "Unknown Trans KPI Uraian";
    String UNKNOWN_TRANS_KPI_URAIAN_FILE = "Unknown Trans KPI Uraian File";
    String TRANS_KPI_URAIAN_FILE_ALREADY_EXIST = "File already exist";
    String UNKNOWN_TRANS_PERILAKU_NILAI = "Unknown Trans Perilaku Nilai";
}
