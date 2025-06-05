package com.adrLuceros.transporte.ProgramacionPreeliminar.Application.Service;

import java.io.InputStream;
import java.util.List;



import org.apache.poi.ss.usermodel.Workbook;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adrLuceros.transporte.Almacen.Application.DTO.AlamcenDTO;
import com.adrLuceros.transporte.Almacen.Application.Service.AlmacenService;
import com.adrLuceros.transporte.ProgramacionPreeliminar.Application.Mapper.PPMaper;
import com.adrLuceros.transporte.ProgramacionPreeliminar.Domain.Models.ModelExcel;
import com.adrLuceros.transporte.Tienda.application.DTO.TiendaDTO;
import com.adrLuceros.transporte.Tienda.application.service.TiendaService;
import com.adrLuceros.transporte.Unidad.Application.DTO.UnidadDTO;
import com.adrLuceros.transporte.Unidad.Application.Service.UnidadService;
import com.monitorjbl.xlsx.StreamingReader;

@Service
public class PPService {

    private final PPMaper ppMapper;
    private final TiendaService tiendaService;
    private final AlmacenService almacenService;
    private final UnidadService unidadService;

    public PPService(PPMaper ppMapper, TiendaService tiendaService, AlmacenService almacenService, UnidadService unidadService) {
        this.ppMapper = ppMapper;
        this.tiendaService = tiendaService;
        this.almacenService = almacenService;
        this.unidadService = unidadService;
    }

    public List<ModelExcel> getAll(MultipartFile file) throws Exception {

        InputStream is = file.getInputStream();

        Workbook workbook = StreamingReader.builder()
                .rowCacheSize(100) // Número de filas en caché
                .bufferSize(4096) // Tamaño del búfer
                .open(is);
        List<ModelExcel> modelExcelList = ppMapper.Mapear(workbook); 
        logicaparaTienda(modelExcelList);
        logicaparaUnidad(modelExcelList);

        return modelExcelList;
    }


    private void logicaparaTienda(List<ModelExcel>   modelExcelList  ){
        for (ModelExcel modelExcel : modelExcelList) {

              TiendaDTO tiendaTrue =  tiendaService.findByNombreTiendaAndCodigoTienda(modelExcel.getTienda(), modelExcel.getDestinatario());
            
            if (tiendaTrue != null) {
                tiendaTrue = new TiendaDTO();
                tiendaTrue.setNombreTienda(modelExcel.getTienda());
                tiendaTrue.setCodigoTienda(modelExcel.getDestinatario());
                tiendaTrue.setDireccion(modelExcel.getDireccion());


                 tiendaService.updateTienda(tiendaTrue);
                
            } else {
                TiendaDTO tiendaDTO = ppMapper.modelExcelToTiendaDTO(modelExcel);
                tiendaService.saveTienda(tiendaDTO);
                
            }
        }   
    }

    private AlamcenDTO logicaparaAlmacen(List<ModelExcel>   modelExcelList  ){
        return null;

    }

    private void logicaparaUnidad(List<ModelExcel>   modelExcelList  ){
        for (ModelExcel modelExcel : modelExcelList) {
            UnidadDTO unidadTrue = unidadService.findByPlaca( modelExcel.getPlaca());
            if (unidadTrue == null) {
                unidadTrue = new UnidadDTO();
                unidadTrue.setPlaca( modelExcel.getPlaca());
                unidadService.save(unidadTrue);
            }

        }

    }


}
