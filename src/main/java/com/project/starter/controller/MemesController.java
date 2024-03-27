package com.project.starter.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema.ConflictResolutionFunction.Resolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.starter.data.MemeEntity;
import com.project.starter.exchange.AllMemesListDto;
import com.project.starter.exchange.IdResponseDto;
import com.project.starter.service.MemeService;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MemesController {

    private final MemeService memeService;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/memes")
    public ResponseEntity<List<MemeEntity>> getMemes()
    {   
        List<MemeEntity> allMemes = memeService.getAllMemes();
        return ResponseEntity.ok(allMemes);
    }

    @GetMapping("/memes/{id}")
    public ResponseEntity<MemeEntity> getMemesByExtId(@PathVariable int id)
    {
        MemeEntity memeEntity = memeService.getByExternalId(id);

        if(memeEntity != null)
        {
            return new ResponseEntity<MemeEntity>(memeEntity,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/memes")
    public ResponseEntity<IdResponseDto> addMeme(@RequestBody MemeEntity memeEntity)
    {
        if(memeEntity.getCaption() == null || memeEntity.getName() == null || memeEntity.getUrl() == null)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<MemeEntity> allMemesList = memeService.getAllMemes();
  
        boolean isDuplicateentry = false;
        String message = "Not a duplcuate";
        for(MemeEntity m : allMemesList)
        {
            if(m.getName().equals(memeEntity.getName()))
            {
                isDuplicateentry = true;
                message = m.getName() + " "+ "-> already exists in database.";
                break;
            }
            else if(m.getCaption().equals(memeEntity.getCaption()))
            {
                isDuplicateentry = true;
                message = m.getCaption() + " "+ "-> already exists in database.";
                break;
            }
            else if(m.getUrl().equals(memeEntity.getCaption()))
            {
                isDuplicateentry = true;
                message = m.getUrl() + " "+ "-> already exists in database.";
                break;
            }
            else 
            {

            }
        }

        if(isDuplicateentry == false)
        {
            int id = Integer.parseInt(Long.toString(counter.incrementAndGet()));
            memeEntity.setId(id);
            memeService.saveMeme(memeEntity);
            return new ResponseEntity<>(new IdResponseDto(id),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
    
}
