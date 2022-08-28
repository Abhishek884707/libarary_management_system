package com.mindtree.library_management_system.controller;

import com.mindtree.library_management_system.dto.BorrowedDto;
import com.mindtree.library_management_system.model.Borrowed;
import com.mindtree.library_management_system.service.BorrowedService;
import com.mindtree.library_management_system.utilities.BorrowedUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("library_management_system/v1/")
@CrossOrigin("*")
public class BorrowedController {

    @Autowired
    BorrowedService borrowedService;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/borrowed")
    public List<BorrowedDto> retrieveAllBorrows(){
        List<BorrowedDto> borrowedDtoList = borrowedService.getAllBorrowed().stream().map(borrowed -> BorrowedUtility.fromBorrowedToBorrowedDto(borrowed)).collect(Collectors.toList());
        return borrowedDtoList;
    }

    @GetMapping("/borrowed/search/{search}")
    public List<BorrowedDto> searchIntoBorrowedList(@PathVariable("search") String search){
        List<BorrowedDto> borrowedDtoList = borrowedService.searchIntoBorrows(search).stream().map(borrowed -> BorrowedUtility.fromBorrowedToBorrowedDto(borrowed)).collect(Collectors.toList());
        return borrowedDtoList;
    }

    @GetMapping("/borrowed/{borrowedId}")
    public BorrowedDto getBorrowedById(@PathVariable("borrowedId") int id){
        log.info("{}",id);
        BorrowedDto BorrowedDto = BorrowedUtility.fromBorrowedToBorrowedDto(borrowedService.getBorrowedById(id).get());
        return BorrowedDto;
    }

    @PostMapping("/borrowed")
    public BorrowedDto createNewBorrowed(@RequestBody BorrowedDto borrowedDto){
        log.info("{}", borrowedDto);
        System.err.println(borrowedDto.getBook().getName());
        System.err.println(borrowedDto.getStudent().getFirstName());
        Borrowed Borrowed = BorrowedUtility.fromBorrowedDtoToBorrowed(borrowedDto);
        borrowedDto = BorrowedUtility.fromBorrowedToBorrowedDto(borrowedService.addNewBorrowed(Borrowed));
        return borrowedDto;
    }

    @PutMapping("/borrowed")
    public BorrowedDto editBorrowed(@RequestBody BorrowedDto borrowedDto, @RequestHeader("my-operation") String myOperation){
        log.info("{}", borrowedDto);
        System.err.println(borrowedDto.getBook().getName());
        System.err.println(borrowedDto.getStudent().getFirstName());
        System.err.println(myOperation);
        Borrowed Borrowed = BorrowedUtility.fromBorrowedDtoToBorrowed(borrowedDto);
        borrowedDto = BorrowedUtility.fromBorrowedToBorrowedDto(borrowedService.updateBorrowed(Borrowed, myOperation));
        return borrowedDto;
    }

    @DeleteMapping("/borrowed")
    public boolean removeBorrowed(@RequestBody BorrowedDto borrowedDto){
        log.info("{}", borrowedDto);
        Borrowed Borrowed = BorrowedUtility.fromBorrowedDtoToBorrowed(borrowedDto);
        return borrowedService.deleteBorrowed(Borrowed);
    }


}
