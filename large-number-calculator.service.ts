import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class LargeNumberCalculatorService {
  constructor() {}

  getMultiplied(a: string, b: string) {
    /*
       xx
      *xx
      multiply by start digit, resolve carry, which is xx/10
      shift next row, one digit left = add zero or 10 times the amount of times you make new row
      multiply by next digit, resolve carry, which is xx/10
      add all
    */

    const toSum: string[] = [];
    let power = "";

    for (let i = b.length - 1; i >= 0; i--) {
      const str = b.charAt(i);
      const num = parseInt(str, 10);

      const calculatedRow = this.getMultipliedByOneDigit(a, num);

      const toSumStr = calculatedRow + "" + power;
      power += 0;
      toSum.push(toSumStr);
    }

    const result = this.getAddedArray(toSum);
    return result;
  }

  getMultipliedByOneDigit(a: string, b: number): string {
    const toSum: string[] = [];
    let power = "";

    for (let i = a.length - 1; i >= 0; i--) {
      const str = a.charAt(i);
      const num = parseInt(str, 10);
      const multiplied = num * b;

      const toSumStr = multiplied + "" + power;
      power += "0";
      toSum.push(toSumStr);
    }
    const result = this.getAddedArray(toSum);
    return result;
  }

  getAddedArray(arr: string[]): string {
    let currentResult = arr[0];
    for (let i = 1; i < arr.length; i++) {
      const row = arr[i];
      currentResult = this.getSummed(currentResult, row);
    }
    return currentResult;
  }

  getSummed(a: string, b: string) {
    let result = "";
    let topNumber = a;
    let bottomNumber = b;
    let carry = 0;
    if (a.length < b.length) {
      topNumber = b;
      bottomNumber = a;
    }
    let nextDigit = 0;

    for (let i = 0; i < topNumber.length; i++) {
      let numBottom = 0;
      const numTop = parseInt(topNumber.charAt(topNumber.length - 1 - i), 10);

      if (nextDigit < bottomNumber.length) {
        numBottom = parseInt(
          bottomNumber.charAt(bottomNumber.length - 1 - nextDigit),
          10
        );
      }
      nextDigit++;

      const sum = numTop + numBottom + carry;
      const reminder = sum % 10;

      carry = (sum - reminder) / 10;
      result = reminder + result;
    }

    if (carry > 0) {
      result = carry + result;
    }

    return result;
  }
}
