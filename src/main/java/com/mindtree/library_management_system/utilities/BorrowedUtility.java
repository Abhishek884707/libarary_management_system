package com.mindtree.library_management_system.utilities;

import com.mindtree.library_management_system.dto.BorrowedDto;
import com.mindtree.library_management_system.model.Borrowed;

import java.time.LocalDateTime;

public class BorrowedUtility {

    public static BorrowedDto fromBorrowedToBorrowedDto(Borrowed borrowed){
        BorrowedDto borrowedDto = new BorrowedDto();

        borrowedDto.setId(borrowed.getId());
        borrowedDto.setStudent(borrowed.getStudent());
        borrowedDto.setBook(borrowed.getBook());
        borrowedDto.setIssuedDate(borrowed.getIssuedDate().toString());
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
        date = borrowedDto.getIssuedDate().replace("Z","");
        borrowed.setIssuedDate(LocalDateTime.parse(date));
        borrowed.setRenewedCount(borrowedDto.getRenewedCount());

        return borrowed;
    }


}
