import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SearchBestRestaurantsRequestDTO} from "../model/search-best-restaurants-request-dto.model";

@Injectable({ providedIn:'root'})
export class RestaurantService {

  constructor(private http: HttpClient) { }

  private BASIC_URL: string = 'restaurants/';

  public findAll() {
    return this.http.get(this.BASIC_URL, { observe: 'response' });
  }

  public findBestMatchedRestaurants(searchBestRestaurantsRequestDTO: SearchBestRestaurantsRequestDTO) {
    return this.http.post(this.BASIC_URL + 'findBestMatchedRestaurants', searchBestRestaurantsRequestDTO, { observe: 'response' });
  }

}
