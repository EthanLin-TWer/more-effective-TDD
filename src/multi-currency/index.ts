export default class Dollar {
  amount: number

  constructor(amount: number) {
    this.amount = amount
  }

  times(multiplications: number) {
    return new Dollar(this.amount * multiplications)
  }
}
