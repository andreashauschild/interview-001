package org.acme.rest;

import com.google.common.io.ByteStreams;
import org.acme.database.ImportLogEntity;
import org.acme.database.ReportDataEntity;
import org.apache.commons.io.FilenameUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the rest service endpoint of the application
 */
@Path("/service")
public class ServiceEndpointResource {

    // see application.properties
    @ConfigProperty(name = "file.upload.path")
    String uploadFolder;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("hello")
    public String hello() {
        // TODO why the hell is demo code still here
        return "hello";
    }


    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("uploadReport")
    public String uploadReport(@MultipartForm ReportUploadRequest data) throws IOException {
        java.nio.file.Path directories = Files.createDirectories(Paths.get(uploadFolder));
        byte[] bytes = ByteStreams.toByteArray(data.getFile());
        String fileName = FilenameUtils.getName(data.getFileName());
        Files.write(directories.resolve(fileName), bytes);
        save(bytes, fileName);
        return "OK";
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("uploadImage")
    @Deprecated
    public String uploadImage(@MultipartForm ReportUploadRequest data) throws IOException {
        // FIXME it is depcreated since years we should check a removal of this function
//        java.nio.file.Path directories = Files.createDirectories(Paths.get(uploadFolder));
//        byte[] bytes = ByteStreams.toByteArray(data.getFile());
//        String fileName = FilenameUtils.getName(data.getFileName());
//        Files.write(directories.resolve(fileName), bytes);
//        save(bytes, fileName);
        return "FAILED";
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("uploadTxt")
    public String uploadTxt(@MultipartForm ReportUploadRequest data) throws IOException {
        java.nio.file.Path directories = Files.createDirectories(Paths.get(uploadFolder));
        byte[] bytes = ByteStreams.toByteArray(data.getFile());
        String fileName = FilenameUtils.getName(data.getFileName());
        Files.write(directories.resolve(fileName), bytes);
        save(bytes, fileName);
        return "OK";
    }


    public void save(byte[] bytes, String fileName) {
        // FIXME does not work, throws weird exception
        ImportLogEntity importLogEntity = new ImportLogEntity().setFileName(fileName).setSize(bytes.length).setImportTime(LocalDateTime.now());

        // TODO make sure that the bytes are ready as UTF-8
        String csv = new String(bytes);

        for(int i =0;i<parseCsv(csv).size();i++){
            // Here i add a value of the parsed csv
            importLogEntity.getData().add(parseCsv(csv).get(i));
        }
        importLogEntity.persist();
    }

    @Transactional
    public void delete(ImportLogEntity importLogEntity) {
        // TODO check if null

        // delete the entity
        importLogEntity.delete();
    }

    private List<ReportDataEntity> parseCsv(String reportCsv){
        throw new UnsupportedOperationException();
    }
}