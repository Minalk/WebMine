package com.diycomputerscience.minesweeper.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import com.diycomputerscience.minesweeper.Board;
import com.diycomputerscience.minesweeper.Point;
import com.diycomputerscience.minesweeper.Square;
import com.diycomputerscience.minesweeper.RandomMineInitializationStrategy;
import com.diycomputerscience.minesweeper.UncoveredMineException;
import com.diycomputerscience.minesweeper.view.UI;

/**
 * Servlet implementation class MinwsweeperServe
 */
public class MinesweeperServe extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Board board ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MinesweeperServe() {
        super();
        board = new Board(new RandomMineInitializationStrategy());
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
						 HttpServletResponse response) 
								 throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
						  HttpServletResponse response) 
								  throws ServletException, IOException {
		
		System.out.println("Control in doPost()");
		String action = request.getParameter("action");
		System.out.println("Action = "+action);
		int mCount=0;
		JSONObject object=new JSONObject();
		if(action != null){
			
			int row = Integer.parseInt(request.getParameter("row"));
			int col = Integer.parseInt(request.getParameter("col"));
			
			//TODO: Use action to figure out what to do
			Point point = new Point(row, col);
			Square square[][] = board.getSquares();
			response.setContentType("application/json");    
			if(action.equals("leftClick")){
				
				try {
					board.uncover(point);
					mCount = square[row][col].getCount();
					try
				      {  
				            
				            object.put("mCount",mCount);
				       }
				       catch(Exception e)
				       {  
				            throw new ServletException("JSON Hosed up");  
				       }  
					   String json = object.toString();  
				       response.getWriter().write(json);
				       response.getWriter().flush();
		
				}catch(UncoveredMineException ume) {
					mCount = 1000;
					try
				      {  
				            object.put("mCount",mCount);
				       }
				       catch(Exception e)
				       {  
				            throw new ServletException("JSON Hosed up");  
				       }  
					   String json = object.toString();  
				       response.getWriter().write(json);
				       response.getWriter().flush();
					
					}
			// Display the board
			}
			else{//rightClick
				try
			      {  
			    
					object.put("mCount",mCount);
			      }
				  catch(Exception e)
			      {  
			           throw new ServletException("JSON Hosed up");  
			      }  
				   String json = object.toString();  
			       response.getWriter().write(json);
			       response.getWriter().flush();
			}
			//displayBoard(request, response);
		}
	}
	
	private void displayBoard(HttpServletRequest request,
							  HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("game.jsp").forward(request, response);
		return;
	}

}
