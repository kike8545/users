import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {User} from '../interfaces/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {}
  private url = 'http://localhost:8080/users/';


  findAll(): Observable<User[]> {
    return this.http.get<User[]>(`${this.url}`);
  }

  edit(form: any): Observable<any> {
    return this.http.put<User>(`${this.url}`, form);
  }

  add(user: User): Observable<User> {
    return this.http.post<User>(`${this.url}`, user);
  }



}
