import {Component} from '@angular/core';
import {RestaurantService} from "../../service/restaurant.service";

@Component({
  selector: 'app-best-matched-restaurant-list',
  templateUrl: './best-matched-restaurant-list.component.html',
  styleUrls: ['./best-matched-restaurant-list.component.css']
})
export class BestMatchedRestaurantListComponent {

  restaurants: any = [];

  constructor(private restaurantService: RestaurantService) { }

  share() {
    window.alert('The product has been shared!');
  }

  findBestMatchedRestaurants() {
    this.restaurantService.findAll().subscribe((resp: any) => {
        console.log(resp.body);
      this.restaurants = resp.body;
    }, (error: { message: any; }) => window.alert(error.message));
  }
}


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at https://angular.io/license
*/