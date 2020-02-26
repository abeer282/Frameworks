import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VirtualMachineService {

  private baseUrl = 'http://localhost:8080/api/v1/vm';

  constructor(private http: HttpClient) { }

  getVirtualMachine(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createVirtualMachine(virtualMachine: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, virtualMachine);
  }

  updateVirtualMachine(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteVirtualMachine(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getVirtualMachinesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
