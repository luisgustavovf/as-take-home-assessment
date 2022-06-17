import {Component} from '@angular/core';
import {RestaurantService} from "../../service/restaurant.service";
import {SearchBestRestaurantsRequestDTO} from "../../model/search-best-restaurants-request-dto.model";

@Component({
  selector: 'app-best-matched-restaurant-list',
  templateUrl: './best-matched-restaurant-list.component.html',
  styleUrls: ['./best-matched-restaurant-list.component.css']
})
export class BestMatchedRestaurantListComponent {

  restaurants: any = [];

  searchBestRestaurantsRequestDTO: SearchBestRestaurantsRequestDTO = new SearchBestRestaurantsRequestDTO();

  constructor(private restaurantService: RestaurantService) { }

  findBestMatchedRestaurants() {
    this.restaurantService.findBestMatchedRestaurants(this.searchBestRestaurantsRequestDTO).subscribe({
      next: (resp: any) => { this.restaurants = resp.body; },
      error: (error: { message: any; }) => window.alert(error.message)
  });
  }
}