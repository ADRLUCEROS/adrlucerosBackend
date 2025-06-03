package com.adrLuceros.transporte.ProgramacionPreeliminar.Application.Mapper;

import java.util.List;
import java.util.stream.StreamSupport;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.adrLuceros.transporte.ProgramacionPreeliminar.Domain.Models.ModelExcel;
import com.adrLuceros.transporte.Tienda.application.DTO.TiendaDTO;

@Component

public class PPMaper {

    private final ModelMapper modelMapper;
        public PPMaper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        // Configurar para ignorar campos null al mapear
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setSkipNullEnabled(true);
    }

        public List<ModelExcel> Mapear(Workbook workbook){
                List<ModelExcel> modelExcelList = StreamSupport.stream(workbook.spliterator(), false)
                .flatMap(sheet -> StreamSupport.stream(sheet.spliterator(), false))
                .skip(1)
                .map(con -> {
                    ModelExcel modelExcel = new ModelExcel();
                    modelExcel.setClienteCorporativo(getStringSafe(con.getCell(0)));
                    modelExcel.setPlaca(getStringSafe(con.getCell(1)));
                    modelExcel.setAlmacen(getStringSafe(con.getCell(2)));
                    modelExcel.setPsex(getStringSafe(con.getCell(3)));
                    modelExcel.setDestinatario(getStringSafe(con.getCell(4)));
                    modelExcel.setTienda(getStringSafe(con.getCell(5)));
                    modelExcel.setDistrito(getStringSafe(con.getCell(6)));
                    modelExcel.setDireccion(getStringSafe(con.getCell(7)));
                    modelExcel.setVh(getStringSafe(con.getCell(8)));
                    modelExcel.setObservaciones(getStringSafe(con.getCell(10)));
                    return modelExcel;
                }).toList();
            return modelExcelList;

    }

    public TiendaDTO modelExcelToTiendaDTO(ModelExcel modelExcel) {
        TiendaDTO tiendaDTO = new TiendaDTO();
        tiendaDTO.setNombreTienda(modelExcel.getTienda());
        tiendaDTO.setCodigoTienda(modelExcel.getDestinatario());
        tiendaDTO.setDireccion(modelExcel.getDireccion());
        return tiendaDTO;
    }

        private String getStringSafe(Cell cell) {
        if (cell == null)
            return null;

        return switch (cell.getCellType()) {
            case STRING -> {
                String value = cell.getStringCellValue();
                yield value == null || value.trim().isEmpty() ? null : value.trim();
            }
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            case BOOLEAN -> String.valueOf(cell.getBooleanCellValue());
            case FORMULA -> cell.getCellFormula();
            default -> null;
        };
    }


    
}
