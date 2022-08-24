package com.mindtree.libarary_management_system.utilities;

import com.mindtree.libarary_management_system.dto.BorrowedDto;
import com.mindtree.libarary_management_system.model.Borrowed;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BorrowedUtility {

    public static BorrowedDto fromBorrowedToBorrowedDto(Borrowed borrowed){
        BorrowedDto borrowedDto = new BorrowedDto();

        borrowedDto.setId(borrowed.getId());
        borrowedDto.setStudent(borrowed.getStudent());
        borrowedDto.setBook(borrowed.getBook());
        borrowedDto.setIssuedDate(borrowed.getIssuedDate().toString());
        if(borrowed.getReturnDate() != null){
            borrowedDto.setReturnDate(borrowed.getReturnDate().toString());
        }else{
            borrowedDto.setReturnDate(null);
        }
        borrowedDto.setFine(borrowed.getFine());
        borrowedDto.setRenewedCount(borrowed.getRenewedCount());

        return borrowedDto;
    }

    public static Borrowed fromBorrowedDtoToBorrowed(BorrowedDto borrowedDto){
        Borrowed borrowed = new Borrowed();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String date = "";
        borrowed.setId(borrowedDto.getId());
        borrowed.setStudent(borrowedDto.getStudent());
        borrowed.setBook(borrowedDto.getBook());
        if(borrowedDto.getReturnDate() != null){
            date = borrowedDto.getReturnDate().replace("Z","");
            borrowed.setReturnDate(LocalDateTime.parse(date));
        }else{
            borrowed.setReturnDate(null);
        }
        date = borrowedDto.getIssuedDate().replace("Z","");
        borrowed.setIssuedDate(LocalDateTime.parse(date));
        borrowed.setFine(borrowedDto.getFine());
        borrowed.setRenewedCount(borrowedDto.getRenewedCount());

        return borrowed;
    }


}
