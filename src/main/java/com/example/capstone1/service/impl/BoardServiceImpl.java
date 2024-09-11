package com.example.capstone1.service.impl;

import com.example.capstone1.domain.Board;
import com.example.capstone1.repository.BoardRepository;
import com.example.capstone1.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository)
    {
        this.boardRepository = boardRepository;
    }

    @Override
    public Map<String, Object> createBoard(Map<String, Object> params){
       Board board = new Board();
       board.setId(Integer.parseInt(params.get("id").toString()));
       board.setTitle(params.get("title").toString());
       board.setContent(params.get("content").toString());
       board.setAuthor(params.get("author").toString());
       boardRepository.save(board);
        System.out.println("정상적으로 생성되었습니다");
       return null;

    }
    public Map<String, Object> updateBoard(Map<String, Object> params){
        Board board = boardRepository.findById(Integer.parseInt(params.get("id") + "")).orElseThrow(() -> new RuntimeException(""));
        board.setTitle(params.get("title").toString());
        board.setContent(params.get("content").toString());
        board.setAuthor(params.get("author").toString());
        boardRepository.save(board);
        System.out.println("정상적으로 업데이트 되었습니다");
        return null;
    }
    public Map<String, Object> deleteBoard(Integer id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        boardRepository.delete(board);
        System.out.println("정상적으로 삭제되었습니다");
        return null;

    }
    public List<Board> listBoard(){
        return boardRepository.findAll();
    }
    public Board detailBoard(Integer id){
        return boardRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }
}
