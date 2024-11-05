import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RobotService {

  constructor(private http: HttpClient) {}

  moveRobot(moves: string){
    return this.http.post<string>(`http://localhost:8080/rest/mars/${moves}`, {}, {responseType: 'text' as 'json'}).pipe(
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    return throwError(() => new Error(`Movimentos invalidos. Erro ${error.status} na API`))
  }
  
}
