import { Component, OnInit } from '@angular/core';
import { Hero } from "./hero";
import { HEROES } from "./heroes-mock";
import { HeroService } from "./hero.service";
import { Router } from "@angular/router";


@Component({
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css'],
  selector: 'my-heroes',
})
export class HeroesComponent implements OnInit {
  selectedHero: Hero;
  name = 'Angular';
  heroes: Hero[];

  constructor(private router: Router, private heroService: HeroService) { }

  ngOnInit(): void {
    this.getHeroes();
  }

  getHeroes(): void {
    this.heroService.getHeroesSlowly().then(heroes => this.heroes = heroes);
  }

  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }

  gotoDetail(): void {
    this.router.navigate(['/detail', this.selectedHero.id]);
  }

}

