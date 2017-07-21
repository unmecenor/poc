import { Injectable } from '@angular/core';
import { Hero } from "./hero";
import { HEROES } from "./heroes-mock";
import { Headers, Http } from "@angular/http";
import 'rxjs/add/operator/toPromise';

@Injectable()
export class HeroService {

    private heroesUrl = 'api/heroes';
    private headers = new Headers({ 'Content type': 'application/json' });

    constructor(private http: Http) { }

    getHeroes(): Promise<Hero[]> {
        return this.http.get(this.heroesUrl)
            .toPromise()
            .then(response => response.json().data as Hero[])
            .catch(this.handleError);
    }

    getHeroesSlowly(): Promise<Hero[]> {
        return new Promise(resolve => {
            setTimeout(() => resolve(this.getHeroes()), 2000);
        });
    }

    getHero(id: number): Promise<Hero> {
        //return this.getHeroes().then(heroes => heroes.find(hero => hero.id === id));
        return this.http.get(`${this.heroesUrl}/${id}`)
            .toPromise()
            .then(response => response.json().data as Hero)
            .catch(this.handleError);
    }

    update(hero: Hero): Promise<Hero> {
        return this.http.put(
            `${this.heroesUrl}/${hero.id}`,
            JSON.stringify(hero),
            { headers: this.headers })
            .toPromise().then(() => hero).catch(this.handleError);
    }

    add(heroName: string): Promise<Hero> {
        return this.http.post(
            this.heroesUrl,
            JSON.stringify({ name: heroName }),
            { headers: this.headers })
            .toPromise()
            .then(response => response.json().data as Hero)
            .catch(this.handleError);
    }

    delete(id: number): Promise<void> {
        return this.http.delete(`${this.heroesUrl}/${id}`, { headers: this.headers })
            .toPromise()
            .then(() => null)
            .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        // for demo purposes only
        console.error('An error occured richi!', error);
        return Promise.reject(error.message || error);
    }
}