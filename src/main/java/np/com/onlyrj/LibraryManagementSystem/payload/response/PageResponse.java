package np.com.onlyrj.LibraryManagementSystem.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import np.com.onlyrj.LibraryManagementSystem.payload.dto.BookDTO;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PageResponse<T> {
    private List<T> content;
    private int pageNumber;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;
    private boolean empty;

    public PageResponse(List<BookDTO> bookDTOS, int number, int size, long totalElements, int totalPages, boolean last, boolean first, boolean empty) {
    }
}


