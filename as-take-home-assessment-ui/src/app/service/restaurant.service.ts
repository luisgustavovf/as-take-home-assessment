import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({ providedIn:'root'})
export class RestaurantService {

  constructor(private http: HttpClient) { }

  private BASIC_URL: string = 'restaurants/';

  public findAll() {
    return this.http.get(this.BASIC_URL, { observe: 'response' });
  }

}
