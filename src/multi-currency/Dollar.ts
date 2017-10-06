import Money from './Money'

export default class Dollar extends Money {
  constructor(amount: number) {
    super(amount)
  }

  public times(multiplications: number): Dollar {
    return new Dollar(this.amount * multiplications)
  }
}
