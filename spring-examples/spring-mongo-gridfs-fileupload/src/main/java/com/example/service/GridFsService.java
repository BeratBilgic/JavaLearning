package com.example.service;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class GridFsService {
    private final GridFsTemplate gridFsTemplate;

    public GridFsService(GridFsTemplate gridFsTemplate) {
        this.gridFsTemplate = gridFsTemplate;
    }

    public String uploadFile(MultipartFile file) throws Exception {
        DBObject dbObject = new BasicDBObject();
        dbObject.put("filename", file.getOriginalFilename());
        dbObject.put("contentType", file.getContentType());
        dbObject.put("size", file.getSize());
        dbObject.put("userId", "12345");
        ObjectId id = gridFsTemplate.store(file.getInputStream(),file.getOriginalFilename(), dbObject);
        System.out.println(id.toString());
        return id.toString();
    }

    public GridFSFile findOne(String id){
        GridFSFile gridFsFile = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
        return gridFsFile;
    }
}
