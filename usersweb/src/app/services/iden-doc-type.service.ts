import {Injectable} from '@angular/core';
import {Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {IdenDocType} from '../interfaces/IdenDocType';

@Injectable({
  providedIn: 'root'
})
export class IdenDocTypeService {

  constructor(private http: HttpClient) {}
  public url = 'http://localhost:8080/';

  /**
   * Metodo encargado de listar los tipos de documentos
   * 18/05/2020
   */
  findAll(): Observable<IdenDocType[]> {
    return this.http.get<IdenDocType[]>(`${this.url}` + 'idenDocType');
  }

}
